package com.dais.model;

public class AddressPool {
    private Integer fid;

    private Integer fviType;

    private String faddress;

    private Integer fstatus;

    private Integer version;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFviType() {
        return fviType;
    }

    public void setFviType(Integer fviType) {
        this.fviType = fviType;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress == null ? null : faddress.trim();
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}