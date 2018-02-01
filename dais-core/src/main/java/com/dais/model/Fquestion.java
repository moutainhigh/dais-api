package com.dais.model;

import java.util.Date;

public class Fquestion {
    private Integer fid;

    private Integer ftype;

    private String ftelephone;

    private Integer fuid;

    private Integer fstatus;

    private Date fcreatetime;

    private Date fsolvetime;

    private Integer faid;

    private String fname;

    private Integer version;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public String getFtelephone() {
        return ftelephone;
    }

    public void setFtelephone(String ftelephone) {
        this.ftelephone = ftelephone == null ? null : ftelephone.trim();
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Date getFsolvetime() {
        return fsolvetime;
    }

    public void setFsolvetime(Date fsolvetime) {
        this.fsolvetime = fsolvetime;
    }

    public Integer getFaid() {
        return faid;
    }

    public void setFaid(Integer faid) {
        this.faid = faid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}