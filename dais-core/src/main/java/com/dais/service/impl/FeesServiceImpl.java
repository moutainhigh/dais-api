package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.dais.mapper.FeesMapper;
import com.dais.mapper.FfeesMapper;
import com.dais.model.*;
import com.dais.service.FeesService;
import com.dais.service.FfeesService;
import com.dais.service.VirtualCoinService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 09- 09 18:16
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class FeesServiceImpl implements FeesService {

    @Autowired
    private FeesMapper feesMapper;

    @Override
    public int insert(Fees fees) {
        return feesMapper.insertSelective(fees);
    }

    @Override
    public int update(Fees fees) {
        return feesMapper.updateByPrimaryKeySelective(fees);
    }

    @Override
    public ResultModel selectFees(int start, int limit, String search) {
        FeesExample example = new FeesExample();
        if(StringUtils.isNotBlank(search)){
            FeesExample.Criteria criteria = new FeesExample().createCriteria();
            criteria.andCoinnameLike("%"+search+"%");
            example.or(criteria);
        }
        PageHelper.startPage(start, limit);
        List<Fees> feess = this.feesMapper.selectByExample(example);
        PageInfo<Fees> pageInfo = new PageInfo<>(feess);
        return ResultModel.build(200, "OK", pageInfo);
    }

    @Override
    public List<Fees> selectFees() {
        FeesExample example = new FeesExample();
        List<Fees> feess = this.feesMapper.selectByExample(example);
        return feess;
    }

    @Override
    public Fees selectFees(int symbol) {
        FeesExample example = new FeesExample();
        example.createCriteria().andSymbolEqualTo(symbol);
        List<Fees> feess = this.feesMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(feess)){
            return null;
        }
        return feess.get(0);
    }
}
