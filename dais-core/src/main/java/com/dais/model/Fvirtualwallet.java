package com.dais.model;

import java.math.BigDecimal;
import java.util.Date;

public class Fvirtualwallet {
    private Integer fid;

    private Integer fviFid;

    private Double ftotal;

    private Double ffrozen;

    private Date flastupdatetime;

    private Integer fuid;

    private BigDecimal fborrowbtc;

    private BigDecimal fcanlendbtc;

    private BigDecimal ffrozenlendbtc;

    private BigDecimal falreadylendbtc;

    private Integer version;

    private BigDecimal fhaveappointborrowbtc;

    private Boolean ishow;

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


    public Double getFtotal() {
        return ftotal;
    }

    public void setFtotal(Double ftotal) {
        this.ftotal = ftotal;
    }

    public Double getFfrozen() {
        return ffrozen;
    }

    public void setFfrozen(Double ffrozen) {
        this.ffrozen = ffrozen;
    }

    public Date getFlastupdatetime() {
        return flastupdatetime;
    }

    public void setFlastupdatetime(Date flastupdatetime) {
        this.flastupdatetime = flastupdatetime;
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public BigDecimal getFborrowbtc() {
        return fborrowbtc;
    }

    public void setFborrowbtc(BigDecimal fborrowbtc) {
        this.fborrowbtc = fborrowbtc;
    }

    public BigDecimal getFcanlendbtc() {
        return fcanlendbtc;
    }

    public void setFcanlendbtc(BigDecimal fcanlendbtc) {
        this.fcanlendbtc = fcanlendbtc;
    }

    public BigDecimal getFfrozenlendbtc() {
        return ffrozenlendbtc;
    }

    public void setFfrozenlendbtc(BigDecimal ffrozenlendbtc) {
        this.ffrozenlendbtc = ffrozenlendbtc;
    }

    public BigDecimal getFalreadylendbtc() {
        return falreadylendbtc;
    }

    public void setFalreadylendbtc(BigDecimal falreadylendbtc) {
        this.falreadylendbtc = falreadylendbtc;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getFhaveappointborrowbtc() {
        return fhaveappointborrowbtc;
    }

    public void setFhaveappointborrowbtc(BigDecimal fhaveappointborrowbtc) {
        this.fhaveappointborrowbtc = fhaveappointborrowbtc;
    }

    public Boolean getIshow() {
        return ishow;
    }

    public void setIshow(Boolean ishow) {
        this.ishow = ishow;
    }
}