package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.Account;
import com.dais.model.Fvirtualcointype;
import com.dais.model.FvirtualcointypeExample;
import com.dais.model.Fvirtualwallet;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/10
 */
public interface VirtualCoinService {
    List<Fvirtualcointype> findFvirtualCoinTypeByStatus(Integer status);
    int updateVirtualCoinByExample(Fvirtualcointype fvc, FvirtualcointypeExample example);
    Fvirtualcointype selectByPrimaryKey(Integer fid);
    List<Fvirtualcointype> selectByExample(FvirtualcointypeExample example);
    ResultModel getParams(int start, int limit, String search);
    ResultModel updateWithdrawBtc(String fvirtualaddressWithdraw, Fvirtualcointype fvirtualcointype,
                                 Fvirtualwallet fvirtualwallet, double withdrawAmount,
                                 Integer userId,String remarks,String userAddress,Double fees,boolean falg);
    ResultModel updateWithdraw(String fvirtualaddressWithdraw,
                               Fvirtualcointype fvirtualcointype,
                               Account account,
                               double withdrawAmount,
                               Integer userId,String remarks,String userAddress,Double fees);
}
