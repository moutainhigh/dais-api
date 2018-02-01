package com.dais.bean;

/**
 * @author xxp
 * @version 2017- 09- 27 17:10
 * @description
 * @copyright www.zhgtrade.com
 */
public class MsgBean {
    private Integer type;
    private int touserId;
    private String msgContent;

    public int getTouserId() {
        return touserId;
    }

    public void setTouserId(int touserId) {
        this.touserId = touserId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
