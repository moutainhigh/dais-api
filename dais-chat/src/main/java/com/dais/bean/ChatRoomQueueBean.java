package com.dais.bean;

import com.common.pojo.ResultModel;

import javax.websocket.Session;

/**
 * @author xxp
 * @version 2017- 09- 29 10:17
 * @description
 * @copyright www.zhgtrade.com
 */
public class ChatRoomQueueBean {
    private ResultModel resultModel;

    private Session session;

    public ResultModel getResultModel() {
        return resultModel;
    }

    public void setResultModel(ResultModel resultModel) {
        this.resultModel = resultModel;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
