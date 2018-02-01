package com.dais.model;

public class AutoWithdrawAuth {
    private Integer id;

    private Integer withdrawOprationId;

    private Integer symbol;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWithdrawOprationId() {
        return withdrawOprationId;
    }

    public void setWithdrawOprationId(Integer withdrawOprationId) {
        this.withdrawOprationId = withdrawOprationId;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}