package com.dais.service.impl;

import com.dais.mapper.FfeesMapper;
import com.dais.model.Ffees;
import com.dais.service.FfeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GanZhen
 * @version 2017- 09- 09 18:16
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class FfeesServiceImpl implements FfeesService {

    @Autowired
    private FfeesMapper ffeesMapper;

    @Override
    public int insert(Ffees ffees) {
        return ffeesMapper.insert(ffees);
    }

    @Override
    public int update(Ffees ffees) {
        return 0;
    }

    @Override
    public int selectFfees(int start, int limit, String search) {
        return 0;
    }
}
