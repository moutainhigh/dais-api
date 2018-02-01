package com.dais.model;

import java.util.Date;

public class RongcloudUsertoken {
    private Integer id;

    private Integer userId;

    private String token;

    private Date createTime;

    private Date updateTime;

    private Integer refreshtimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRefreshtimes() {
        return refreshtimes;
    }

    public void setRefreshtimes(Integer refreshtimes) {
        this.refreshtimes = refreshtimes;
    }
}