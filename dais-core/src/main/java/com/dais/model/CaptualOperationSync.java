package com.dais.model;

import java.math.BigDecimal;
import java.util.Date;

public class CaptualOperationSync {
    private Integer id;

    private String coinName;

    private Integer operationId;

    private Integer userid;

    private Integer symbol;

    private Date createtime;

    private Double amount;

    private Double fees;

    private Integer opertionType;

    private Integer status;

    private Date lastUpdatetime;

    private String withdrawVirtualAddress;

    private String userName;

    private String userPhone;

    private String rechargeVirtualAddress;

    private String ftradeuniquenumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName == null ? null : coinName.trim();
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Integer getOpertionType() {
        return opertionType;
    }

    public void setOpertionType(Integer opertionType) {
        this.opertionType = opertionType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(Date lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }

    public String getWithdrawVirtualAddress() {
        return withdrawVirtualAddress;
    }

    public void setWithdrawVirtualAddress(String withdrawVirtualAddress) {
        this.withdrawVirtualAddress = withdrawVirtualAddress == null ? null : withdrawVirtualAddress.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
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
}