package com.dais.service.impl;

import com.dais.mapper.AutoWithdrawAuthMapper;
import com.dais.model.AutoWithdrawAuth;
import com.dais.model.AutoWithdrawAuthExample;
import com.dais.service.AutoWithdrawAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 09- 13 19:41
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class AutoWithdrawAuthServiceImpl implements AutoWithdrawAuthService{

    @Autowired
    private AutoWithdrawAuthMapper autoWithdrawAuthMapper;

    @Override
    public List<AutoWithdrawAuth> selectAutoWithdrawAuth() throws Exception {
        AutoWithdrawAuthExample example = new AutoWithdrawAuthExample();
        example.createCriteria().andStatusLessThanOrEqualTo(1);
        List<AutoWithdrawAuth> list = this.autoWithdrawAuthMapper.selectByExample(example);
        return list;
    }

    @Override
    public int updateWithdrawAuth(AutoWithdrawAuth autoWithdrawAuth) {
        int rows = autoWithdrawAuthMapper.updateByPrimaryKeySelective(autoWithdrawAuth);
        if(rows > 0){
            return rows;
        }
        throw new RuntimeException();
    }
}
