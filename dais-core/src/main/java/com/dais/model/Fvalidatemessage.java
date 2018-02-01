package com.dais.model;

import java.util.Date;

public class Fvalidatemessage {
    private Integer fid;

    private Integer fusFid;

    private String fphone;

    private Integer fstatus;

    private Byte type;

    private Date fcreatetime;

    private Date fsendtime;

    private Integer version;

    private String fcontent;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFusFid() {
        return fusFid;
    }

    public void setFusFid(Integer fusFid) {
        this.fusFid = fusFid;
    }

    public String getFphone() {
        return fphone;
    }

    public void setFphone(String fphone) {
        this.fphone = fphone == null ? null : fphone.trim();
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Date getFsendtime() {
        return fsendtime;
    }

    public void setFsendtime(Date fsendtime) {
        this.fsendtime = fsendtime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }
}