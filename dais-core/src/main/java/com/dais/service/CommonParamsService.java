package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.CommonParams;
import com.dais.model.CommonParamsExample;

import java.util.List;
import java.util.Objects;

/**
 * 招股金服
 * CopyRight : www.zhgtrade.com
 * Author : liuyuanbo
 * Date： 2017/8/11
 */
public interface CommonParamsService {
    String getValue(String key);
    ResultModel getParams(int start, int limit, String search);
    ResultModel insert(CommonParams commonParams);
    ResultModel update(CommonParams commonParams);
    ResultModel delete(Integer id);
}
