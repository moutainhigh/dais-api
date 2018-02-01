package com.dais.model;

import java.math.BigDecimal;

public class Fees {
    private Integer id;

    private Double minfees;

    private Integer version;

    private Double maxfees;

    private Integer symbol;

    private Integer level;

    private String coinname;

    private String unit;

    private String rate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Double getMinfees() {
        return minfees;
    }

    public void setMinfees(Double minfees) {
        this.minfees = minfees;
    }

    public Double getMaxfees() {
        return maxfees;
    }

    public void setMaxfees(Double maxfees) {
        this.maxfees = maxfees;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCoinname() {
        return coinname;
    }

    public void setCoinname(String coinname) {
        this.coinname = coinname == null ? null : coinname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }
}