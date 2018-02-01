package com.dais.service;

import com.dais.model.Fvirtualwallet;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/10
 */
public interface FvirtualwalletService {
    Fvirtualwallet selectFvirtualwallet(Integer userId, Integer symbol);

    Fvirtualwallet selectFvirtualwallet(Integer userId, Integer symbol,boolean flag);

    public List<Fvirtualwallet> listFvirtualwallet(Integer userId);

    Fvirtualwallet insertFvirtualwallet(Integer userId, Integer symbol);

    int updateFvirtualwallet(Fvirtualwallet fvirtualwallet);
}
