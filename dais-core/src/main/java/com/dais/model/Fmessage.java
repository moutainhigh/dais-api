package com.dais.model;

import java.util.Date;

public class Fmessage {
    private Integer fid;

    private Integer fstatus;

    private String ftitle;

    private String fcontent;

    private Integer freceiverid;

    private Integer fcreatorid;

    private Date fcreatetime;

    private String operationid;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }

    public Integer getFreceiverid() {
        return freceiverid;
    }

    public void setFreceiverid(Integer freceiverid) {
        this.freceiverid = freceiverid;
    }

    public Integer getFcreatorid() {
        return fcreatorid;
    }

    public void setFcreatorid(Integer fcreatorid) {
        this.fcreatorid = fcreatorid;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid == null ? null : operationid.trim();
    }
}