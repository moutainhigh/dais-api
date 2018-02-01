package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.CaptualOperationSync;
import com.dais.model.Fvirtualcaptualoperation;
import com.dais.model.Fvirtualcointype;

/**
 * @author xxp
 * @version 2017- 09- 07 21:09
 * @description
 * @copyright www.zhgtrade.com
 */
public interface CaptualOperationSyncService {
    ResultModel getWithdrawOperationList(int start, int limit, String search,int type);
    int insert(CaptualOperationSync captualOperationSync) throws Exception;
    int updateByParam(CaptualOperationSync captualOperationSync) throws Exception;
    int insertByParam(Fvirtualcaptualoperation fvirtualcaptualoperation ,
                             Fvirtualcointype fvirtualcointype) throws Exception;
}
