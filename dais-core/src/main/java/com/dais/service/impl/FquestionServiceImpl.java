package com.dais.service.impl;

import com.dais.mapper.FquestionMapper;
import com.dais.model.Fquestion;
import com.dais.model.FquestionWithBLOBs;
import com.dais.service.FquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GanZhen
 * @version 2017- 08- 18 14:46
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class FquestionServiceImpl implements FquestionService {

    @Autowired
    private FquestionMapper fquestionMapper;

    @Override
    public int insertFquestion(FquestionWithBLOBs fquestion) {
        return this.fquestionMapper.insert(fquestion);
    }
}
