package com.dais.model;

public class WalletUnlockInfo {
    private Integer id;

    private Integer symbol;

    private String coinName;

    private String unlockPassword;

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

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName == null ? null : coinName.trim();
    }

    public String getUnlockPassword() {
        return unlockPassword;
    }

    public void setUnlockPassword(String unlockPassword) {
        this.unlockPassword = unlockPassword == null ? null : unlockPassword.trim();
    }
}