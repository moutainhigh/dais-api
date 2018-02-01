package com.dais.service;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/11
 */
public interface ValidateService {
    public int getLimitCount(String ip, int type);

    public void updateLimitCount(String ip, int type);

    public void deleteCountLimite(String ip, int type);
}
