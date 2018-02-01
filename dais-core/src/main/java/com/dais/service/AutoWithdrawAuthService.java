package com.dais.service;

import com.dais.model.AutoWithdrawAuth;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 09- 13 19:36
 * @description
 * @copyright www.zhgtrade.com
 */
public interface AutoWithdrawAuthService {

    List<AutoWithdrawAuth> selectAutoWithdrawAuth() throws Exception;
    int updateWithdrawAuth(AutoWithdrawAuth autoWithdrawAuth);
}
