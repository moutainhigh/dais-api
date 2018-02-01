package com.dais.service;

import com.dais.model.Ffees;

/**
 * @author GanZhen
 * @version 2017- 09- 09 18:14
 * @description
 * @copyright www.zhgtrade.com
 */
public interface FfeesService {

    int insert(Ffees ffees);

    int update(Ffees ffees);

    int selectFfees(int start, int limit, String search);
}
