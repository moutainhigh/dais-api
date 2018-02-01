package com.dais.model;

import java.util.Date;

public class Fvirtualaddress_withdraw {
    private Integer fid;

    private Integer fviFid;

    private String flabel;

    private String fadderess;

    private Integer fuid;

    private Date fcreatetime;

    private Integer version;

    private Boolean init;

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

    public String getFlabel() {
        return flabel;
    }

    public void setFlabel(String flabel) {
        this.flabel = flabel == null ? null : flabel.trim();
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

    public Boolean getInit() {
        return init;
    }

    public void setInit(Boolean init) {
        this.init = init;
    }
}