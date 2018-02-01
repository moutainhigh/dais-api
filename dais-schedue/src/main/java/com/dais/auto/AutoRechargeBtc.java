package com.dais.auto;

import com.common.Enum.VirtualCapitalOperationInStatusEnum;
import com.common.Enum.VirtualCapitalOperationTypeEnum;
import com.common.Enum.VirtualCoinTypeStatusEnum;
import com.common.model.BTCInfo;
import com.common.model.BTCMessage;
import com.common.utils.BTCUtils;
import com.common.utils.CollectionUtils;
import com.common.utils.Utils;
import com.dais.mapper.FvirtualcaptualoperationMapper;
import com.dais.model.Fvirtualaddress;
import com.dais.model.Fvirtualcaptualoperation;
import com.dais.model.Fvirtualcointype;
import com.dais.model.PublicBlockAccount;
import com.dais.service.*;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class AutoRechargeBtc {
    private static final Logger log = LoggerFactory
            .getLogger(AutoRechargeBtc.class);
    @Autowired
    private RechargeBtcData rechargeBtcData;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;
    @Autowired
    private FvirtualaddressService fvirtualaddressService;
    @Autowired
    private CaptualOperationSyncService captualOperationSyncService;
    @Autowired
    private FvirtualcaptualoperationMapper fvirtualcaptualoperationMapper;
    @Autowired
    private PublicBlockAccountService publicBlockAccountService;

    public void work() {
        synchronized (this) {
            try {
                //遍历现有的
                List<Fvirtualcointype> fvirtualcointypes = this.virtualCoinService.findFvirtualCoinTypeByStatus(VirtualCoinTypeStatusEnum.Normal);
                //获取钱包中新数据
                for (Fvirtualcointype fvirtualcointype : fvirtualcointypes) {
                    try {
                        log.info("sync {}", fvirtualcointype.getFid());
                        // 上次获取的第一个交易号
                        String lastTradeNo = this.rechargeBtcData.getLastTradeRecordMap(fvirtualcointype.getFid());
                        int begin = 0;
                        int step = 200;//lastTradeNo==null?Integer.MAX_VALUE:200 ;
                        boolean is_continue = true;

                        if (fvirtualcointype == null || fvirtualcointype.getFstatus() == VirtualCoinTypeStatusEnum.Abnormal) {
                            continue;
                        }
                        BTCMessage btcMessage = new BTCMessage();
                        btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey());
                        btcMessage.setIP(fvirtualcointype.getFip());
                        btcMessage.setPORT(fvirtualcointype.getFport());
                        btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey());

                        String firstTradeNo = null;
                        BTCUtils btcUtils = new BTCUtils(btcMessage);
                        List<BTCInfo> btcInfos = new ArrayList<BTCInfo>();

                        while (is_continue) {
                            try {
                                btcInfos = btcUtils.listtransactionsValue(step, begin);
                                log.error(fvirtualcointype.getFid() + " listtransaction {}, {}, {}", step, begin, btcInfos.size());
                                begin += step;
                                if (firstTradeNo == null && btcInfos.size() > 0) {
                                    firstTradeNo = btcInfos.get(0).getTxid().trim();
                                }

                                if (CollectionUtils.isEmpty(btcInfos)) {
                                    // 没有更多数据
                                    is_continue = false;
                                }
                            } catch (Exception e1) {
//										e1.printStackTrace();
                                is_continue = false;
                                continue;
                            }

                            for (BTCInfo btcInfo : btcInfos) {

                                String txid = btcInfo.getTxid().trim();
//										System.out.println("正在循环读取每一条记录："+txid);
                                if (txid.equals(lastTradeNo)) {
                                    // 到达上次获取位置
                                    is_continue = false;
                                }
                                List<Fvirtualcaptualoperation> fvirtualcaptualoperations = this.fvirtualcaptualoperationService.selectByTypeAndTradeUniqueNumber(VirtualCapitalOperationTypeEnum.COIN_IN, txid);
                                if (fvirtualcaptualoperations.size() > 0) {
                                    continue;
                                }
                                Fvirtualcaptualoperation fvirtualcaptualoperation = new Fvirtualcaptualoperation();

                                boolean hasOwner = true;
                                boolean IsSystemAccount = false;
                                int userid = 0;
                                String address = btcInfo.getAddress().trim();
                                List<Fvirtualaddress> fvirtualaddresses = this.fvirtualaddressService.findFvirtualaddress(address, fvirtualcointype.getParentid());
                                if (fvirtualaddresses.size() == 0) {
                                    PublicBlockAccount publicBlockAccount = this.publicBlockAccountService.getPublicBlockAccount(address);
                                    if(publicBlockAccount != null){
                                        IsSystemAccount = true;
                                    }else{
                                        hasOwner = false;
                                    }
                                } else if (fvirtualaddresses.size() > 1) {
                                    log.error("Dumplicate Fvirtualaddress for address:" + address + " ,Fvirtualcointype:" + fvirtualcointype.getFid());
                                    continue;
                                } else {
                                    Fvirtualaddress fvirtualaddress = fvirtualaddresses.get(0);
                                    userid = fvirtualaddress.getFuid();

                                }
                                fvirtualcaptualoperation.setFusFid2(userid);
                                fvirtualcaptualoperation.setIsSystemAccount(IsSystemAccount);
                                fvirtualcaptualoperation.setFhasowner(hasOwner);
                                fvirtualcaptualoperation.setFamount(btcInfo.getAmount());
                                fvirtualcaptualoperation.setFcreatetime(new Timestamp(btcInfo.getTime().getTime()));
                                fvirtualcaptualoperation.setFfees(0D);
                                fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());

                                fvirtualcaptualoperation.setFconfirmations(1);
                                fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationInStatusEnum.WAIT_0);
                                String tradeuniquenumber = btcInfo.getTxid().trim();
                                if(btcInfo.getTxid().trim().indexOf("-") <0){
                                    tradeuniquenumber = tradeuniquenumber + "-" +btcInfo.getAddress().trim();
                                }
                                fvirtualcaptualoperation.setFtradeuniquenumber(tradeuniquenumber);
                                fvirtualcaptualoperation.setRechargeVirtualAddress(btcInfo.getAddress().trim());
                                fvirtualcaptualoperation.setWithdrawVirtualAddress(btcInfo.getAccount().trim());
                                fvirtualcaptualoperation.setFtype(VirtualCapitalOperationTypeEnum.COIN_IN);
                                fvirtualcaptualoperation.setFviFid2(fvirtualcointype.getFid());
//										fvirtualcaptualoperation.setFisPreAudit(false);
                                try {
//											System.out.println("成功读取一条记录！");
                                    this.fvirtualcaptualoperationMapper.insertSelective(fvirtualcaptualoperation);
                                    this.captualOperationSyncService.insertByParam(fvirtualcaptualoperation,fvirtualcointype);
//                                    fvirtualcaptualoperation = fvirtualcaptualoperationService.selectByTypeAndTradeUniqueNumber(fvirtualcaptualoperation.getFtype(),fvirtualcaptualoperation.getFtradeuniquenumber()).get(0);
                                    this.rechargeBtcData.subPut(fvirtualcointype.getFid(), fvirtualcaptualoperation.getFtradeuniquenumber(), fvirtualcaptualoperation);
                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    log.info("充值异常"+e);
                                    e.printStackTrace();
                                }

                            }//for


                        }//while
                        if (firstTradeNo != null) {
                            this.rechargeBtcData.setTradeRecordMap(fvirtualcointype.getFid(), firstTradeNo);
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }//for

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


    //加密
    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static Key toKey(byte[] key) throws Exception {
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    private static String encrypt(String data, String key) throws Exception {
        Key k = toKey(Base64.decodeBase64(key.getBytes()));                           //还原密钥
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);              //实例化Cipher对象，它用于完成实际的加密操作
        cipher.init(Cipher.ENCRYPT_MODE, k);                               //初始化Cipher对象，设置为加密模式
        return new String(Base64.encodeBase64(cipher.doFinal(data.getBytes()))); //执行加密操作。加密后的结果通常都会用Base64编码进行传输
    }

    private static String decrypt(String data, String key) throws Exception {
        Key k = toKey(Base64.decodeBase64(key.getBytes()));
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);                          //初始化Cipher对象，设置为解密模式
        return new String(cipher.doFinal(Base64.decodeBase64(data.getBytes()))); //执行解密操作
    }
}
