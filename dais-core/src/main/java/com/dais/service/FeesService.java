package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.Fees;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 09- 09 18:14
 * @description
 * @copyright www.zhgtrade.com
 */
public interface FeesService {

    int insert(Fees fees);

    int update(Fees fees);

    ResultModel selectFees(int start, int limit, String search);

    List<Fees> selectFees();
    Fees selectFees(int symbol);
}
