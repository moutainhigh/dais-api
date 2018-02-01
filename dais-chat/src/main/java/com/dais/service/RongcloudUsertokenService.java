package com.dais.service;


/**
 * @author xxp
 * @version 2017- 09- 25 14:54
 * @description
 * @copyright www.zhgtrade.com
 */
public interface RongcloudUsertokenService {

    String getToken(int userid)throws Exception;
    boolean refreshUserInfo(int userid) throws Exception;
    String getNewToken(int userid) throws Exception;
}
