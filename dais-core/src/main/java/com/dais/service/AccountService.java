package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.Account;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 10- 10 18:49
 * @description
 * @copyright www.zhgtrade.com
 */
public interface AccountService {
    List getAccount(int userid);
    Account getAccount(int userid ,int symbol);
    Account getAccountByKey(int id);
    int insertAccount(Account account);
    int updateAccount(Account account);
    ResultModel updateExchange(double withdrawAmount,String tradePassword, Account account,
                               String remarks,int touserId)throws Exception;
}
