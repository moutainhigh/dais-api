package com.dais.model;

import java.util.Date;

public class Fcountlimit {
    private Integer fid;

    private String fip;

    private Date fcreatetime;

    private Integer fcount;

    private Integer ftype;

    private Integer version;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFip() {
        return fip;
    }

    public void setFip(String fip) {
        this.fip = fip == null ? null : fip.trim();
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}