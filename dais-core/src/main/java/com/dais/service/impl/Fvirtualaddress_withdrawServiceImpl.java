package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.dais.mapper.Fvirtualaddress_withdrawMapper;
import com.dais.model.Fvirtualaddress_withdraw;
import com.dais.model.Fvirtualaddress_withdrawExample;
import com.dais.service.Fvirtualaddress_withdrawService;
import com.dais.utils.Utils;
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
public class Fvirtualaddress_withdrawServiceImpl implements Fvirtualaddress_withdrawService {
    @Autowired
    Fvirtualaddress_withdrawMapper fvirtualaddress_withdrawMapper;

    @Override
    public int deleteByPrimaryKey(Integer fid) {
        return fvirtualaddress_withdrawMapper.deleteByPrimaryKey(fid);
    }

    @Override
    public int insert(Fvirtualaddress_withdraw record) {
        return fvirtualaddress_withdrawMapper.insert(record);
    }

    @Override
    public ResultModel insertFvirtualaddressWithdraw(Fvirtualaddress_withdraw record, Integer userId) {
        Fvirtualaddress_withdraw fvaw =new Fvirtualaddress_withdraw();
        fvaw.setVersion(0);
        fvaw.setFuid(userId);
        fvaw.setFviFid(record.getFviFid());
        fvaw.setFlabel(record.getFlabel());
        fvaw.setFadderess(record.getFadderess());
        fvaw.setFcreatetime(Utils.getTimestamp());
        fvaw.setInit(record.getInit());
        int count = this.fvirtualaddress_withdrawMapper.insertSelective(fvaw);
        if(count == 0){
            return ResultModel.build(500,"数据异常");
        }
        return ResultModel.ok();
    }

    @Override
    public List<Fvirtualaddress_withdraw> selectFvirtualaddressWithdraw(Integer userId,Integer symbol) {
        Fvirtualaddress_withdrawExample example = new Fvirtualaddress_withdrawExample();
        if(symbol == null || symbol == 0){
            example.createCriteria().andFuidEqualTo(userId);
        }else{
            example.createCriteria().andFviFidEqualTo(symbol).andFuidEqualTo(userId);
        }
        return fvirtualaddress_withdrawMapper.selectByExample(example);
    }

    @Override
    public Fvirtualaddress_withdraw selectByPrimaryKey(Integer fid) {
        return fvirtualaddress_withdrawMapper.selectByPrimaryKey(fid);
    }

    @Override
    public int updateByPrimaryKey(Fvirtualaddress_withdraw record) {
        return fvirtualaddress_withdrawMapper.updateByPrimaryKey(record);
    }
}
