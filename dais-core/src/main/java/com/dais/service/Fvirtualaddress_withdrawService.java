package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.Fvirtualaddress_withdraw;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/10
 */
public interface Fvirtualaddress_withdrawService {
    int deleteByPrimaryKey(Integer fid);
    int insert(Fvirtualaddress_withdraw record);
    ResultModel insertFvirtualaddressWithdraw(Fvirtualaddress_withdraw record, Integer userId);
    List<Fvirtualaddress_withdraw> selectFvirtualaddressWithdraw(Integer userId, Integer symbol);
    Fvirtualaddress_withdraw selectByPrimaryKey(Integer fid);
    int updateByPrimaryKey(Fvirtualaddress_withdraw record);
}
