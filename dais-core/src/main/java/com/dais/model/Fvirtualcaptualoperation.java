package com.dais.model;

import java.util.Date;

public class Fvirtualcaptualoperation {
    private Integer fid;

    private Integer fusFid2;

    private Integer fviFid2;

    private Date fcreatetime;

    private Double famount;

    private Double ffees;

    private Integer ftype;

    private Integer fstatus;

    private Date flastupdatetime;

    private Integer version;

    private String withdrawVirtualAddress;

    private String rechargeVirtualAddress;

    private String ftradeuniquenumber;

    private Integer fconfirmations;

    private Boolean fhasowner;

    private Boolean ishomeshow;

    private Integer blockindex;

    private Boolean isSystemAccount;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFusFid2() {
        return fusFid2;
    }

    public void setFusFid2(Integer fusFid2) {
        this.fusFid2 = fusFid2;
    }

    public Integer getFviFid2() {
        return fviFid2;
    }

    public void setFviFid2(Integer fviFid2) {
        this.fviFid2 = fviFid2;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Double getFamount() {
        return famount;
    }

    public void setFamount(Double famount) {
        this.famount = famount;
    }

    public Double getFfees() {
        return ffees;
    }

    public void setFfees(Double ffees) {
        this.ffees = ffees;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public Date getFlastupdatetime() {
        return flastupdatetime;
    }

    public void setFlastupdatetime(Date flastupdatetime) {
        this.flastupdatetime = flastupdatetime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getWithdrawVirtualAddress() {
        return withdrawVirtualAddress;
    }

    public void setWithdrawVirtualAddress(String withdrawVirtualAddress) {
        this.withdrawVirtualAddress = withdrawVirtualAddress == null ? null : withdrawVirtualAddress.trim();
    }

    public String getRechargeVirtualAddress() {
        return rechargeVirtualAddress;
    }

    public void setRechargeVirtualAddress(String rechargeVirtualAddress) {
        this.rechargeVirtualAddress = rechargeVirtualAddress == null ? null : rechargeVirtualAddress.trim();
    }

    public String getFtradeuniquenumber() {
        return ftradeuniquenumber;
    }

    public void setFtradeuniquenumber(String ftradeuniquenumber) {
        this.ftradeuniquenumber = ftradeuniquenumber == null ? null : ftradeuniquenumber.trim();
    }

    public Integer getFconfirmations() {
        return fconfirmations;
    }

    public void setFconfirmations(Integer fconfirmations) {
        this.fconfirmations = fconfirmations;
    }

    public Boolean getFhasowner() {
        return fhasowner;
    }

    public void setFhasowner(Boolean fhasowner) {
        this.fhasowner = fhasowner;
    }

    public Boolean getIshomeshow() {
        return ishomeshow;
    }

    public void setIshomeshow(Boolean ishomeshow) {
        this.ishomeshow = ishomeshow;
    }

    public Integer getBlockindex() {
        return blockindex;
    }

    public void setBlockindex(Integer blockindex) {
        this.blockindex = blockindex;
    }

    public Boolean getIsSystemAccount() {
        return isSystemAccount;
    }

    public void setIsSystemAccount(Boolean isSystemAccount) {
        this.isSystemAccount = isSystemAccount;
    }
}