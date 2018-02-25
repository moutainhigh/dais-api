package com.dais.service.impl;

import com.common.utils.CollectionUtils;
import com.dais.mapper.AddressPoolMapper;
import com.dais.mapper.FvirtualaddressMapper;
import com.dais.model.Fvirtualaddress;
import com.dais.model.FvirtualaddressExample;
import com.dais.service.FvirtualaddressService;
import com.dais.utils.StringUtils;
import com.dais.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/10
 */
@Service
public class FvirtualaddressServiceImpl implements FvirtualaddressService{
    private static Logger logger = Logger.getLogger(FvirtualaddressServiceImpl.class);
    @Autowired
    FvirtualaddressMapper fvirtualaddressMapper;

    @Autowired
    AddressPoolMapper addressPoolMapper;

    @Override
    public Fvirtualaddress selectFvirtualAddress(Integer userId,Integer symbol) {
        FvirtualaddressExample fvirtualaddressExample = new FvirtualaddressExample();
        fvirtualaddressExample.createCriteria().andFuidEqualTo(userId).andFviFidEqualTo(symbol);
        List<Fvirtualaddress> fvaList = this.fvirtualaddressMapper.selectByExample(fvirtualaddressExample);
        // 若没有地址 则分配地址，同时创建一个钱包
        if (CollectionUtils.isEmpty(fvaList)) {
            return null;
        }
        return fvaList.get(0);
    }

    @Override
    public Fvirtualaddress selectFvaByAddress(String address) {
        FvirtualaddressExample example = new FvirtualaddressExample();
        example.createCriteria().andFadderessEqualTo(address);
        //根据用户输入的地址去用户充值地址中查找
        List<Fvirtualaddress> list = this.fvirtualaddressMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Fvirtualaddress> listFvirtualAddress(Integer userId,Integer symbol) {
        FvirtualaddressExample fvirtualaddressExample = new FvirtualaddressExample();
        fvirtualaddressExample.createCriteria().andFuidEqualTo(userId).andFviFidEqualTo(symbol);
        List<Fvirtualaddress> fvaList = this.fvirtualaddressMapper.selectByExample(fvirtualaddressExample);
        return fvaList;
    }

    @Override
    public List<Fvirtualaddress> listFvirtualAddressBySymbol(Integer symbol) {
        FvirtualaddressExample fvirtualaddressExample = new FvirtualaddressExample();
        fvirtualaddressExample.createCriteria().andFviFidEqualTo(symbol);
        List<Fvirtualaddress> fvaList = this.fvirtualaddressMapper.selectByExample(fvirtualaddressExample);
        return fvaList;
    }

    @Override
    public List<Fvirtualaddress> listFvirtualAddress(Integer userId) {
        FvirtualaddressExample fvirtualaddressExample = new FvirtualaddressExample();
        fvirtualaddressExample.createCriteria().andFuidEqualTo(userId);
        List<Fvirtualaddress> fvaList = this.fvirtualaddressMapper.selectByExample(fvirtualaddressExample);
        return fvaList;
    }

    public Fvirtualaddress updateAssignWalletAddress(long  userId, int coinId) throws Exception{
        String address = addressPoolMapper.getAssignAddress(coinId);
        if(StringUtils.isEmpty(address)){
            return null;
        }
        Fvirtualaddress fvirtualaddress = new Fvirtualaddress() ;
        fvirtualaddress.setFadderess(address) ;
        fvirtualaddress.setFcreatetime(Utils.getTimestamp()); ;
        fvirtualaddress.setFuid(Integer.valueOf(userId+""));
        fvirtualaddress.setFviFid(coinId);
        fvirtualaddress.setVersion(0);
        fvirtualaddressMapper.insertSelective(fvirtualaddress);
        return fvirtualaddress;
    }

    @Override
    public List<Fvirtualaddress> findFvirtualaddress(String address, Integer symbol) {
        FvirtualaddressExample example = new FvirtualaddressExample();
        FvirtualaddressExample.Criteria criteria = example.createCriteria();
        criteria.andFadderessEqualTo(address);
        criteria.andFviFidEqualTo(symbol);
        return this.fvirtualaddressMapper.selectByExample(example);
    }


}
