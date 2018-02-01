package com.dais.model;

public class FvirtualCoinDesc {
    private Integer id;

    private Integer symbol;

    private String coinDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public String getCoinDesc() {
        return coinDesc;
    }

    public void setCoinDesc(String coinDesc) {
        this.coinDesc = coinDesc == null ? null : coinDesc.trim();
    }
}