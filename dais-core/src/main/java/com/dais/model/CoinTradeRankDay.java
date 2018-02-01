package com.dais.model;

import java.math.BigDecimal;

public class CoinTradeRankDay {
    private Integer id;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal last;

    private BigDecimal vol;

    private BigDecimal buy;

    private BigDecimal sell;

    private Long tradeTime;

    private String priceFlu;

    private String coinType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public Long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getPriceFlu() {
        return priceFlu;
    }

    public void setPriceFlu(String priceFlu) {
        this.priceFlu = priceFlu == null ? null : priceFlu.trim();
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType == null ? null : coinType.trim();
    }
}