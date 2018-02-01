package com.dais.auto;

import com.common.Enum.VirtualCapitalOperationInStatusEnum;
import com.common.Enum.VirtualCoinTypeStatusEnum;
import com.common.model.BTCInfo;
import com.common.model.BTCMessage;
import com.common.utils.BTCUtils;
import com.common.utils.Utils;
import com.dais.model.Fvirtualcaptualoperation;
import com.dais.model.Fvirtualcointype;
import com.dais.service.FvirtualaddressService;
import com.dais.service.FvirtualcaptualoperationService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.List;

@Component
public class AutoRechargeBtcCome {
    private static final Logger log = LoggerFactory
            .getLogger(AutoRechargeBtcCome.class);
    @Autowired
    private RechargeBtcData rechargeBtcData;
    @Autowired
    private VirtualCoinService virtualCoinService;
    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;

    public void work() {
        synchronized (this) {
            try {
                //遍历现有的
                List<Fvirtualcointype> fvirtualcointypes = this.virtualCoinService.findFvirtualCoinTypeByStatus(VirtualCoinTypeStatusEnum.Normal);
                for (Fvirtualcointype fvirtualcointype : fvirtualcointypes) {
                    try {
                        if (fvirtualcointype == null || fvirtualcointype.getFstatus() == VirtualCoinTypeStatusEnum.Abnormal) {
                            continue;
                        }
                        BTCMessage btcMessage = new BTCMessage();
                        btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey());
                        btcMessage.setIP(fvirtualcointype.getFip());
                        btcMessage.setPORT(fvirtualcointype.getFport());
                        btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey());

                        BTCUtils btcUtils = new BTCUtils(btcMessage);

                        String[] tradeNumbers = this.rechargeBtcData.getSubKeys(fvirtualcointype.getFid());
                        for (String tradeNo : tradeNumbers) {
                            Fvirtualcaptualoperation fvirtualcaptualoperation = this.rechargeBtcData.subGet(fvirtualcointype.getFid(), tradeNo);
                            if (fvirtualcaptualoperation != null) {
                                fvirtualcaptualoperation = this.fvirtualcaptualoperationService.selectByPrimaryKey(fvirtualcaptualoperation.getFid());
                                if (fvirtualcaptualoperation.getFstatus() != VirtualCapitalOperationInStatusEnum.SUCCESS) {
                                    BTCInfo btcInfo = null;
                                    try {
                                        String tradeuniquenumber = fvirtualcaptualoperation.getFtradeuniquenumber();
                                        if(fvirtualcointype.getParentid() !=4 && !StringUtils.isEmpty(tradeuniquenumber) && tradeuniquenumber.indexOf("-") > -1){
                                            tradeuniquenumber = tradeuniquenumber.substring(0,tradeuniquenumber.indexOf("-"));
                                        }
                                        btcInfo = btcUtils.gettransactionValue(tradeuniquenumber, "receive");
                                    } catch (Exception e1) {
//												e1.printStackTrace();
                                    }
                                    if (btcInfo == null) {
                                        log.error("Fvirtualcaptualoperation:" + fvirtualcaptualoperation.getFid() + " cannot find in btcwallet!");
                                        continue;
                                    }

                                    if (btcInfo.getConfirmations() >= 0) {
                                        fvirtualcaptualoperation.setFconfirmations(btcInfo.getConfirmations());
                                        fvirtualcaptualoperation.setFamount(btcInfo.getAmount());
                                        fvirtualcaptualoperation.setFfees(btcInfo.getFee());
                                        fvirtualcaptualoperation.setBlockindex(btcInfo.getBlockindex());
                                        switch (btcInfo.getConfirmations()) {
                                            case VirtualCapitalOperationInStatusEnum.WAIT_0:
                                                fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationInStatusEnum.WAIT_0);
                                                break;
                                            case VirtualCapitalOperationInStatusEnum.WAIT_1:
                                                fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationInStatusEnum.WAIT_1);
                                                break;
                                            case VirtualCapitalOperationInStatusEnum.WAIT_2:
                                                fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationInStatusEnum.WAIT_2);
                                                break;
                                            default:
                                                if (fvirtualcaptualoperation.getFconfirmations() >= fvirtualcointype.getConfirmTimes()) {
                                                    fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationInStatusEnum.SUCCESS);
                                                }
                                                break;
                                        }
                                        fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());
                                        try {
                                            this.fvirtualcaptualoperationService.updateFvirtualcaptualoperationCoinIn(fvirtualcaptualoperation);
                                            if (fvirtualcaptualoperation.getFstatus() == VirtualCapitalOperationInStatusEnum.SUCCESS) {
                                                this.rechargeBtcData.subRemove(fvirtualcointype.getFid(), tradeNo);
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                } else {
                                    this.rechargeBtcData.subRemove(fvirtualcointype.getFid(), tradeNo);
                                }
                            } else {
                                this.rechargeBtcData.subRemove(fvirtualcointype.getFid(), tradeNo);
                            }
                        }

//								System.out.println("come loop over " + id);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

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
