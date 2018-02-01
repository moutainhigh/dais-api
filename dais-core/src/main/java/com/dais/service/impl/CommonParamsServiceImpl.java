package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.dais.mapper.CommonParamsMapper;
import com.dais.model.CommonParams;
import com.dais.model.CommonParamsExample;
import com.dais.service.CommonParamsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/11
 */
@Service
public class CommonParamsServiceImpl implements CommonParamsService {
    @Autowired
    CommonParamsMapper commonParamsMapper;

    @Override
    public String getValue(String key) {
        CommonParamsExample commonParamsExample=new CommonParamsExample();
        commonParamsExample.createCriteria().andParamKeyEqualTo(key);
        List<CommonParams> commonParamss=commonParamsMapper.selectByExample(commonParamsExample);
        if (commonParamss==null||commonParamss.size()==0){
            return null;
        }
        return commonParamss.get(0).getParamValue().trim();
    }

    @Override
    public ResultModel getParams(int start, int limit, String search) {
        CommonParamsExample example = new CommonParamsExample();
        CommonParamsExample.Criteria criteria = new CommonParamsExample().createCriteria();
        if(StringUtils.isNotBlank(search)){
            criteria.andParamKeyLike("%"+search+"%");
            example.or(criteria);
            criteria = new CommonParamsExample().createCriteria();
            criteria.andParamValueLike("%"+search+"%");
            example.or(criteria);
            criteria = new CommonParamsExample().createCriteria();
            criteria.andDescriptionLike("%"+search+"%");
            example.or(criteria);
        }
        PageHelper.startPage(start, limit);
        List<CommonParams> paramList = commonParamsMapper.selectByExample(example);
        PageInfo<CommonParams> pageInfo = new PageInfo<>(paramList);
        return ResultModel.build(200, "OK", pageInfo);
    }

    @Override
    public ResultModel insert(CommonParams commonParams) {
        commonParams.setCreated(new Date());
        commonParams.setUpdated(new Date());
        int rows = commonParamsMapper.insertSelective(commonParams);
        if(rows < 1){
            return ResultModel.build(403,"数据异常");
        }
        return ResultModel.ok();
    }

    @Override
    public ResultModel update(CommonParams commonParams) {
        commonParams.setUpdated(new Date());
        int rows = commonParamsMapper.updateByPrimaryKeySelective(commonParams);
        if(rows < 1){
            return ResultModel.build(403,"数据异常");
        }
        return ResultModel.ok();
    }

    @Override
    public ResultModel delete(Integer id) {
        int rows = commonParamsMapper.deleteByPrimaryKey(id);
        if(rows < 1){
            return ResultModel.build(403,"数据异常");
        }
        return ResultModel.ok();
    }
}
