package com.dais.auto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.Enum.VirtualCapitalOperationInStatusEnum;
import com.common.Enum.VirtualCapitalOperationTypeEnum;
import com.common.utils.HttpUtils;
import com.common.utils.JsonUtils;
import com.common.utils.Utils;
import com.dais.mapper.CommonMapper;
import com.dais.mapper.CommonParamsMapper;
import com.dais.mapper.FvirtualcaptualoperationMapper;
import com.dais.model.*;
import com.dais.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2018/2/6
 */
@Component
public class RippleRecharge {

    @Autowired
    private CommonParamsService commonParamsService;
    @Autowired
    private VirtualCoinService virtualCoinService ;
    @Autowired
    private FvirtualaddressService fvirtualaddressService;
    @Autowired
    private FvirtualwalletService fvirtualwalletService;
    @Autowired
    private FvirtualcaptualoperationService fvirtualcaptualoperationService;
    @Autowired
    private FvirtualcaptualoperationMapper fvirtualcaptualoperationMapper;
    @Autowired
    private CaptualOperationSyncService captualOperationSyncService;
    @Autowired
    private CommonMapper commonMapper;

    private static final int step = 500;

    private static final int symbol = 6;

    @PostConstruct
    public void work(){
        synchronized (this){
            try {
                int begin = Integer.parseInt(commonParamsService.getValue("ripple_begin"));
                Fvirtualcointype fvirtualcointype = virtualCoinService.selectByPrimaryKey(symbol);
                String url = "http://"+fvirtualcointype.getFip()+":"+fvirtualcointype.getFport();
                String now = HttpUtils.sendGetRequest(url+"/blockNum",null);
                Integer block = Integer.valueOf(now);  //当前高度
                int time = (block - begin )/step ;
                Map params = new HashMap();
                for(int i = 0;i<= time;i++){
                    params.put("min",begin);
                    begin = begin+step;
                    params.put("max",begin);
                    List<Fvirtualaddress> fvirtualaddresses = fvirtualaddressService.listFvirtualAddressBySymbol(symbol);
                    for (Fvirtualaddress fvirtualaddress : fvirtualaddresses) {
                        try {
                            params.put("address",fvirtualaddress.getFadderess());
                            String result = HttpUtils.sendGetRequest(url+"/getTransactions",params);
                            JSONArray jsonArray = JSONArray.parseArray(result);
                            for(int j = 0; j< jsonArray.size();j++){
                                JSONObject jsonObject = (JSONObject) jsonArray.get(j);
                                String id = jsonObject.getString("id");
                                JSONObject specification = (JSONObject)jsonObject.get("specification");

                                JSONObject source = (JSONObject) specification.get("source");
                                String fromAddress = source.getString("address");

                                JSONObject destination = (JSONObject) specification.get("destination");
                                JSONObject amount = (JSONObject)destination.get("amount");
                                String toAddress = destination.getString("address");
                                Integer tag = destination.getIntValue("tag");
                                String currency = amount.getString("currency");
                                String value = amount.getString("value");

                                JSONObject outcome = (JSONObject) jsonObject.get("outcome");
                                if("XRP".equals(currency) && fvirtualaddress.getFadderess().equals(toAddress)){
                                    List<Fvirtualcaptualoperation> fvirtualcaptualoperations = this.fvirtualcaptualoperationService.selectByTypeAndTradeUniqueNumber(VirtualCapitalOperationTypeEnum.COIN_IN,id+"-"+toAddress);
                                    if(fvirtualcaptualoperations!= null && fvirtualcaptualoperations.size() > 0){
                                        continue;
                                    }
                                    Fvirtualcaptualoperation fvirtualcaptualoperation = new Fvirtualcaptualoperation();
                                    fvirtualcaptualoperation.setFusFid2(fvirtualaddress.getFuid());
                                    fvirtualcaptualoperation.setFamount(Double.valueOf(value));
                                    fvirtualcaptualoperation.setFcreatetime(Utils.getTimestamp());

                                    fvirtualcaptualoperation.setFlastupdatetime(Utils.getTimestamp());
                                    try {
                                        fvirtualcaptualoperation.setFfees(Double.valueOf(outcome.get("fee").toString()));
                                        fvirtualcaptualoperation.setBlockindex(Integer.valueOf(outcome.get("ledgerVersion").toString()));
                                        fvirtualcaptualoperation.setFconfirmations(Integer.valueOf(outcome.get("indexInLedger").toString()));
                                    } catch (Exception e) {
                                    }
                                    fvirtualcaptualoperation.setFstatus(VirtualCapitalOperationInStatusEnum.SUCCESS) ;
                                    fvirtualcaptualoperation.setFtradeuniquenumber(id+"-"+toAddress);
                                    fvirtualcaptualoperation.setRechargeVirtualAddress(toAddress);
                                    fvirtualcaptualoperation.setWithdrawVirtualAddress(fromAddress);
                                    fvirtualcaptualoperation.setFtype(VirtualCapitalOperationTypeEnum.COIN_IN);
                                    fvirtualcaptualoperation.setFviFid2(fvirtualcointype.getFid());
                                    this.fvirtualcaptualoperationMapper.insertSelective(fvirtualcaptualoperation);
                                    this.captualOperationSyncService.insertByParam(fvirtualcaptualoperation,fvirtualcointype);

                                    Fvirtualwallet fvirtualwallet = this.fvirtualwalletService.selectFvirtualwallet(fvirtualaddress.getFuid(), fvirtualcointype.getFid());
                                    if (fvirtualwallet == null){
                                        fvirtualwallet = fvirtualwalletService.insertFvirtualwallet(fvirtualaddress.getFuid(), fvirtualcointype.getFid());
                                    }
                                    String balanceStr = HttpUtils.sendGetRequest(url+"/getBalance",params);
                                    if(!StringUtils.isEmpty(balanceStr)){
                                        JSONArray json = JSONArray.parseArray(balanceStr);
                                        JSONObject temp = (JSONObject) json.get(0);
                                        fvirtualwallet.setFtotal(Double.valueOf(temp.get("value").toString()));
                                    }else {
                                        fvirtualwallet.setFtotal(fvirtualwallet.getFtotal() + Double.valueOf(value));
                                    }
                                    fvirtualwallet.setFlastupdatetime(Utils.getTimestamp());
                                    this.fvirtualwalletService.updateFvirtualwallet(fvirtualwallet);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                commonMapper.update("update  common_params set param_value = '"+begin+"' where param_key = 'ripple_begin'");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
