package com.dais.service.impl;

import com.common.utils.CollectionUtils;
import com.dais.mapper.AddressPoolMapper;
import com.dais.mapper.FvirtualwalletMapper;
import com.dais.model.Fvirtualwallet;
import com.dais.model.FvirtualwalletExample;
import com.dais.service.FvirtualaddressService;
import com.dais.service.FvirtualwalletService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/10
 */
@Service
public class FvirtualwalletServiceImpl implements FvirtualwalletService{
    private static Logger logger = Logger.getLogger(FvirtualwalletServiceImpl.class);
    @Autowired
    FvirtualwalletMapper fvirtualwalletMapper;

    @Autowired
    AddressPoolMapper addressPoolMapper;


    @Override
    public Fvirtualwallet selectFvirtualwallet(Integer userId,Integer symbol) {
        Fvirtualwallet fvw = null;
        try {
            FvirtualwalletExample fvirtualwalletExample = new FvirtualwalletExample();
            FvirtualwalletExample.Criteria criteria = fvirtualwalletExample.createCriteria();
            criteria.andFuidEqualTo(userId);
            criteria.andFviFidEqualTo(symbol);
            List<Fvirtualwallet> list = fvirtualwalletMapper.selectByExample(fvirtualwalletExample);
            if(!CollectionUtils.isEmpty(list)){
                fvw = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fvw;
    }

    @Override
    public Fvirtualwallet selectFvirtualwallet(Integer userId,Integer symbol,boolean flag) {
        Fvirtualwallet fvw = null;
        try {
            FvirtualwalletExample fvirtualwalletExample = new FvirtualwalletExample();
            FvirtualwalletExample.Criteria criteria = fvirtualwalletExample.createCriteria();
            criteria.andFuidEqualTo(userId);
            criteria.andFviFidEqualTo(symbol);
            criteria.andIshowEqualTo(flag);
            List<Fvirtualwallet> list = fvirtualwalletMapper.selectByExample(fvirtualwalletExample);
            if(!CollectionUtils.isEmpty(list)){
                fvw = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fvw;
    }

    @Override
    public List<Fvirtualwallet> listFvirtualwallet(Integer userId) {
        FvirtualwalletExample fvirtualwalletExample = new FvirtualwalletExample();
        FvirtualwalletExample.Criteria criteria = fvirtualwalletExample.createCriteria();
        criteria.andFuidEqualTo(userId);
        criteria.andIshowEqualTo(true);
        return fvirtualwalletMapper.selectByExample(fvirtualwalletExample);
    }

    @Override
    public Fvirtualwallet insertFvirtualwallet(Integer userId, Integer symbol) {
        Fvirtualwallet fvw = new Fvirtualwallet();
        fvw.setFviFid(symbol);
        fvw.setFuid(userId);
        fvw.setFlastupdatetime(new Date());
        fvw.setFtotal(0d);
        fvw.setFfrozen(0d);
        fvirtualwalletMapper.insertSelective(fvw);
        return fvw;
    }

    @Override
    public int updateFvirtualwallet(Fvirtualwallet fvirtualwallet) {
        return this.fvirtualwalletMapper.updateByPrimaryKeySelective(fvirtualwallet);
    }
}
