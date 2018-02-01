package com.dais.service.impl;

import com.dais.mapper.FmessageMapper;
import com.dais.model.Fmessage;
import com.dais.model.FmessageExample;
import com.dais.service.FmessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author GanZhen
 * @version 2017- 08- 18 10:16
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class FmessageServiceImpl implements FmessageService {

    @Autowired
    private FmessageMapper fmessageMapper;

    @Override
    public int insertFmessage(Fmessage fmessage) {
        return fmessageMapper.insert(fmessage);
    }

    @Override
    public int deleteFmessage(int fid) {
        return this.fmessageMapper.deleteByPrimaryKey(fid);
    }

    @Override
    public int insertFmessageByParam(int receiverid, String title, String content) {
        Fmessage fmessage = new Fmessage();
        fmessage.setFcreatetime(new Date());
        fmessage.setFcontent(content);
        fmessage.setFreceiverid(receiverid);
        fmessage.setFtitle(title);
        return this.fmessageMapper.insertSelective(fmessage);
    }

    @Override
    public List<Fmessage> getFmessageByReceiverid(int receiverid,int pageSize,int pageNo) {
        FmessageExample example = new FmessageExample();
        example.createCriteria().andFreceiveridEqualTo(receiverid);
        PageHelper.startPage(pageNo,pageSize);
        return this.fmessageMapper.selectByExample(example);
    }
}
