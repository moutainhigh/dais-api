package com.dais.auto;

import com.common.Enum.VirtualCapitalOperationInStatusEnum;
import com.common.Enum.VirtualCapitalOperationTypeEnum;
import com.common.Enum.VirtualCoinTypeStatusEnum;
import com.common.model.BTCInfo;
import com.common.model.BTCMessage;
import com.common.utils.BTCUtils;
import com.common.utils.DateUtils;
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
public class AutoRechargeBtcAll {
	private static final Logger log = LoggerFactory
			.getLogger(AutoRechargeBtcAll.class);
	@Autowired
	private RechargeBtcData rechargeBtcData ;
	@Autowired
	private VirtualCoinService virtualCoinService ;
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
			try{
				//遍历现有的
				List<Fvirtualcointype> fvirtualcointypes = this.virtualCoinService.findFvirtualCoinTypeByStatus(VirtualCoinTypeStatusEnum.Normal);
				//获取钱包中新数据
				for (Fvirtualcointype fvirtualcointype : fvirtualcointypes) {
					try{
						int begin = 0 ;
						int step = 1000 ;
						boolean is_continue = true ;

						if(fvirtualcointype==null || fvirtualcointype.getFstatus()== VirtualCoinTypeStatusEnum.Abnormal){
							continue ;
						}
//								System.out.println("all wallet loop begin on ip = " + fvirtualcointype.getFip() + " , port = " + fvirtualcointype.getFport());

						BTCMessage btcMessage = new BTCMessage();
						btcMessage.setACCESS_KEY(fvirtualcointype.getFaccessKey());
						btcMessage.setIP(fvirtualcointype.getFip());
						btcMessage.setPORT(fvirtualcointype.getFport());
						btcMessage.setSECRET_KEY(fvirtualcointype.getFsecrtKey());

						String firstAddress = null ;
						BTCUtils btcUtils = new BTCUtils(btcMessage) ;
						List<BTCInfo> btcInfos = new ArrayList<BTCInfo>() ;

						while(is_continue){
							try {
								btcInfos = btcUtils.listtransactionsValue(step, begin) ;
								begin+=step ;
								if(firstAddress==null && btcInfos.size()>0){
									firstAddress = btcInfos.get(0).getTxid().trim() ;
								}
//										System.out.println("本次找到记录共："+btcInfos.size());
								if(btcInfos == null || btcInfos.size() == 0){
									is_continue = false ;
								}
							} catch (Exception e1) {
								//e1.printStackTrace();
								is_continue = false ;
								continue ;
							}

							for (BTCInfo btcInfo : btcInfos) {
								String txid = btcInfo.getTxid().trim() ;
//										System.out.println("正在循环读取每一条记录："+txid);
								List<Fvirtualcaptualoperation> fvirtualcaptualoperations = this.fvirtualcaptualoperationService.selectByTypeAndTradeUniqueNumber(VirtualCapitalOperationTypeEnum.COIN_IN, txid);
								if(fvirtualcaptualoperations.size()>0){
//											System.out.println("记录已经存在");
									continue ;
								}

								Fvirtualcaptualoperation fvirtualcaptualoperation = new Fvirtualcaptualoperation() ;

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

								fvirtualcaptualoperation.setFtradeuniquenumber(btcInfo.getTxid().trim()+"-"+btcInfo.getAddress().trim());
								fvirtualcaptualoperation.setRechargeVirtualAddress(btcInfo.getAddress().trim());
								fvirtualcaptualoperation.setWithdrawVirtualAddress(btcInfo.getAccount().trim());
								fvirtualcaptualoperation.setFtype(VirtualCapitalOperationTypeEnum.COIN_IN);
								fvirtualcaptualoperation.setFviFid2(fvirtualcointype.getFid());
//										fvirtualcaptualoperation.setFisPreAudit(false);
								try {
//											System.out.println("成功读取一条记录！");
									this.fvirtualcaptualoperationMapper.insertSelective(fvirtualcaptualoperation) ;
									this.captualOperationSyncService.insertByParam(fvirtualcaptualoperation,fvirtualcointype);
//											fvirtualcaptualoperation = fvirtualcaptualoperationService.selectByTypeAndTradeUniqueNumber(fvirtualcaptualoperation.getFtype(),fvirtualcaptualoperation.getFtradeuniquenumber()).get(0);
									this.rechargeBtcData.subPut(fvirtualcointype.getFid(), fvirtualcaptualoperation.getFtradeuniquenumber(), fvirtualcaptualoperation) ;
								} catch (Exception e) {
									log.info("充值异常"+e);
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}//for

						}//while
						if(firstAddress!=null){
							this.rechargeBtcData.setTradeRecordMap(fvirtualcointype.getFid(), firstAddress) ;
						}
//								System.out.println("all loop over " + id);
					}catch(Exception e){
						e.printStackTrace() ;
					}
				}//for
			}catch (Exception e) {
				e.printStackTrace() ;
			}

		}

	}













	//加密
	private static final String KEY_ALGORITHM = "AES";
	private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	private static Key toKey(byte[] key) throws Exception{
		return new SecretKeySpec(key, KEY_ALGORITHM);
	}
	private static String encrypt(String data, String key) throws Exception{
		Key k = toKey(Base64.decodeBase64(key.getBytes()));                           //还原密钥
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);              //实例化Cipher对象，它用于完成实际的加密操作
		cipher.init(Cipher.ENCRYPT_MODE, k);                               //初始化Cipher对象，设置为加密模式
		return new String(Base64.encodeBase64(cipher.doFinal(data.getBytes()))); //执行加密操作。加密后的结果通常都会用Base64编码进行传输
	}
	private static String decrypt(String data, String key) throws Exception{
		Key k = toKey(Base64.decodeBase64(key.getBytes()));
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);                          //初始化Cipher对象，设置为解密模式
		return new String(cipher.doFinal(Base64.decodeBase64(data.getBytes()))); //执行解密操作
	}
}
