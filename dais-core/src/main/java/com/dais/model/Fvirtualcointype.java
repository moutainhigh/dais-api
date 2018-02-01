package com.dais.model;

import java.math.BigDecimal;
import java.util.Date;

public class Fvirtualcointype {
    private Integer fid;

    private Integer parentid;

    private String fname;

    private String fshortname;

    private String fdescription;

    private Date faddtime;

    private Integer fstatus;

    private Integer version;

    private String fsymbol;

    private String faccessKey;

    private String fsecrtKey;

    private String fip;

    private String fport;

    private Boolean fisshare;

    private Boolean fiswithdraw;

    private String furl;

    private String fintrourl;

    private BigDecimal fopenprice;

    private BigDecimal ftotalamount;

    private Boolean equitytype;

    private Boolean homeshow;

    private Byte homeorder;

    private Byte typeorder;

    private Byte totalorder;

    private Boolean isstarting;

    private Integer confirmTimes;

    private String contractAddress;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFshortname() {
        return fshortname;
    }

    public void setFshortname(String fshortname) {
        this.fshortname = fshortname == null ? null : fshortname.trim();
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription == null ? null : fdescription.trim();
    }

    public Date getFaddtime() {
        return faddtime;
    }

    public void setFaddtime(Date faddtime) {
        this.faddtime = faddtime;
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

    public String getFsymbol() {
        return fsymbol;
    }

    public void setFsymbol(String fsymbol) {
        this.fsymbol = fsymbol == null ? null : fsymbol.trim();
    }

    public String getFaccessKey() {
        return faccessKey;
    }

    public void setFaccessKey(String faccessKey) {
        this.faccessKey = faccessKey == null ? null : faccessKey.trim();
    }

    public String getFsecrtKey() {
        return fsecrtKey;
    }

    public void setFsecrtKey(String fsecrtKey) {
        this.fsecrtKey = fsecrtKey == null ? null : fsecrtKey.trim();
    }

    public String getFip() {
        return fip;
    }

    public void setFip(String fip) {
        this.fip = fip == null ? null : fip.trim();
    }

    public String getFport() {
        return fport;
    }

    public void setFport(String fport) {
        this.fport = fport == null ? null : fport.trim();
    }

    public Boolean getFisshare() {
        return fisshare;
    }

    public void setFisshare(Boolean fisshare) {
        this.fisshare = fisshare;
    }

    public Boolean getFiswithdraw() {
        return fiswithdraw;
    }

    public void setFiswithdraw(Boolean fiswithdraw) {
        this.fiswithdraw = fiswithdraw;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl == null ? null : furl.trim();
    }

    public String getFintrourl() {
        return fintrourl;
    }

    public void setFintrourl(String fintrourl) {
        this.fintrourl = fintrourl == null ? null : fintrourl.trim();
    }

    public BigDecimal getFopenprice() {
        return fopenprice;
    }

    public void setFopenprice(BigDecimal fopenprice) {
        this.fopenprice = fopenprice;
    }

    public BigDecimal getFtotalamount() {
        return ftotalamount;
    }

    public void setFtotalamount(BigDecimal ftotalamount) {
        this.ftotalamount = ftotalamount;
    }

    public Boolean getEquitytype() {
        return equitytype;
    }

    public void setEquitytype(Boolean equitytype) {
        this.equitytype = equitytype;
    }

    public Boolean getHomeshow() {
        return homeshow;
    }

    public void setHomeshow(Boolean homeshow) {
        this.homeshow = homeshow;
    }

    public Byte getHomeorder() {
        return homeorder;
    }

    public void setHomeorder(Byte homeorder) {
        this.homeorder = homeorder;
    }

    public Byte getTypeorder() {
        return typeorder;
    }

    public void setTypeorder(Byte typeorder) {
        this.typeorder = typeorder;
    }

    public Byte getTotalorder() {
        return totalorder;
    }

    public void setTotalorder(Byte totalorder) {
        this.totalorder = totalorder;
    }

    public Boolean getIsstarting() {
        return isstarting;
    }

    public void setIsstarting(Boolean isstarting) {
        this.isstarting = isstarting;
    }

    public Integer getConfirmTimes() {
        return confirmTimes;
    }

    public void setConfirmTimes(Integer confirmTimes) {
        this.confirmTimes = confirmTimes;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress == null ? null : contractAddress.trim();
    }
}