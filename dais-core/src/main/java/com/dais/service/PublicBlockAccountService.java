package com.dais.service;

import com.dais.model.PublicBlockAccount;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 10- 10 19:14
 * @description
 * @copyright www.zhgtrade.com
 */

public interface PublicBlockAccountService {

    PublicBlockAccount getPublicBlockAccount(String address);

    List<PublicBlockAccount> getPublicBlockAccount(int symbol);

}
