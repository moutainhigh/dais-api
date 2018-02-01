package com.dais.service;

import com.common.pojo.ResultModel;
import com.dais.model.PrivatechatMsg;

import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 09- 27 15:26
 * @description
 * @copyright www.zhgtrade.com
 */
public interface PrivatechatMsgService {

    PrivatechatMsg insertMsg(PrivatechatMsg privatechatMsg);

    List<Map> getUserChat(int userid);

    ResultModel getPrivatechatMsg(int userid,int touserid,int start,int limit);

    ResultModel deleteMsg(String id);

    ResultModel deleteMsg(int userid,int touserid);

    int updateMsg(PrivatechatMsg privatechatMsg);

    List<PrivatechatMsg> getPrivatechatMsgByParam(int status,int userid);
}
