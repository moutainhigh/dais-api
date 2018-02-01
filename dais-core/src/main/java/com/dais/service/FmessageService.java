package com.dais.service;

import com.dais.model.Fmessage;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 08- 18 10:13
 * @description
 * @copyright www.zhgtrade.com
 */
public interface FmessageService {

    public int insertFmessage(Fmessage fmessage);

    public int deleteFmessage(int  fid);

    public int insertFmessageByParam(int receiverid,String title,String content);

    public List<Fmessage> getFmessageByReceiverid(int receiverid,int pageSize,int pageNo);
}
