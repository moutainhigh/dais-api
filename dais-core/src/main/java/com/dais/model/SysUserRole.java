package com.dais.model;

public class SysUserRole {
    private Integer id;

    private Integer sysuserid;

    private Integer sysroleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(Integer sysuserid) {
        this.sysuserid = sysuserid;
    }

    public Integer getSysroleid() {
        return sysroleid;
    }

    public void setSysroleid(Integer sysroleid) {
        this.sysroleid = sysroleid;
    }
}