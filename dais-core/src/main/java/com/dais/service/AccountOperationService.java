package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.AccountOperation;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 10- 12 10:35
 * @description
 * @copyright www.zhgtrade.com
 */
public interface AccountOperationService {

    int insert(AccountOperation accountOperation);
    int save(int symbol,int userid,int touserId,String title,
             String remarks,Double withdrawAmount,double fees,int type);
    ResultModel getAccountOperation(int userid, int start, int limit)throws Exception;
}
