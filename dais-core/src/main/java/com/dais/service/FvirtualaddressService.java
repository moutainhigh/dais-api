package com.dais.service;

import com.dais.model.Fvirtualaddress;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/10
 */
public interface FvirtualaddressService {
    Fvirtualaddress selectFvirtualAddress(Integer userid, Integer symbol);

    Fvirtualaddress selectFvaByAddress(String address);
    List<Fvirtualaddress> listFvirtualAddress(Integer userId);
    List<Fvirtualaddress> listFvirtualAddress(Integer userId, Integer symbol);
    List<Fvirtualaddress> listFvirtualAddressBySymbol(Integer symbol);
    Fvirtualaddress updateAssignWalletAddress(long userId, int coinId) throws Exception;

    List<Fvirtualaddress> findFvirtualaddress(String address,Integer symbol);
}
