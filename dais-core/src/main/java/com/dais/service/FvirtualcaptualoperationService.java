package com.dais.service;

import com.common.pojo.ResultModel;
import com.common.utils.BTCUtils;
import com.dais.model.Fvirtualcaptualoperation;
import com.dais.model.FvirtualcaptualoperationExample;
import com.dais.model.Fvirtualcointype;
import com.dais.model.Fvirtualwallet;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/11
 */
public interface FvirtualcaptualoperationService {
    List<Fvirtualcaptualoperation> selectByExample(Integer userId,Integer status, Integer symbol,
                                                   List<Integer> typeList,boolean ishomeshow,int currentPage,int pageSize);

    Fvirtualcaptualoperation selectByPrimaryKey(Integer fid);

    Fvirtualcaptualoperation selectByExample(FvirtualcaptualoperationExample example);

    int updateByPrimaryKey(Fvirtualcaptualoperation record);

    int insert(Fvirtualcaptualoperation record);

    int countByExample(FvirtualcaptualoperationExample example);

    int getTodayVirtualCoinWithdrawTimes(int userId);

    List<Fvirtualcaptualoperation> selectByTypeAndTradeUniqueNumber(Integer ftype,String ftradeUniqueNumber);

    List<Fvirtualcaptualoperation> findFvirtualcaptualoperation(Integer type,Integer userId,List<Integer> statusList,Integer symbol);

    ResultModel updateCapitaloperationChangeStatus(int type,int uid) throws Exception;

    ResultModel updateCapitalOutAudit(Integer fid,String fpassword) throws Exception;

    void updateCapital(Fvirtualcaptualoperation virtualcaptualoperation,
                              Fvirtualwallet virtualwallet, BTCUtils btcUtils,Fvirtualcointype fvirtualcointype) throws Exception;

    void updateFvirtualcaptualoperationCoinIn(Fvirtualcaptualoperation fvirtualcaptualoperation) throws Exception;

    String getTradeAddress(Fvirtualcaptualoperation fvco);

    String getTradeToAddress(Fvirtualcaptualoperation fvco);

}
