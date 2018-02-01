package com.dais.model;

import java.util.Date;

public class Fvirtualaddress {
    private Integer fid;

    private Integer fviFid;

    private String fadderess;

    private Integer fuid;

    private Date fcreatetime;

    private Integer version;

    private String fname;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFviFid() {
        return fviFid;
    }

    public void setFviFid(Integer fviFid) {
        this.fviFid = fviFid;
    }

    public String getFadderess() {
        return fadderess;
    }

    public void setFadderess(String fadderess) {
        this.fadderess = fadderess == null ? null : fadderess.trim();
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }
}