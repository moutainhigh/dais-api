package com.dais.model;

import java.math.BigDecimal;

public class FvitualCoinTradeRank {
    private Integer id;

    private BigDecimal highestBid;

    private BigDecimal lowestAsk;

    private BigDecimal last;

    private BigDecimal quotevolume;

    private BigDecimal basevolume;

    private BigDecimal low24hr;

    private BigDecimal high24hr;

    private Long tradeTime;

    private BigDecimal percentChange;

    private String coinType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(BigDecimal highestBid) {
        this.highestBid = highestBid;
    }

    public BigDecimal getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(BigDecimal lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getQuotevolume() {
        return quotevolume;
    }

    public void setQuotevolume(BigDecimal quotevolume) {
        this.quotevolume = quotevolume;
    }

    public BigDecimal getBasevolume() {
        return basevolume;
    }

    public void setBasevolume(BigDecimal basevolume) {
        this.basevolume = basevolume;
    }

    public BigDecimal getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(BigDecimal low24hr) {
        this.low24hr = low24hr;
    }

    public BigDecimal getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(BigDecimal high24hr) {
        this.high24hr = high24hr;
    }

    public Long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public BigDecimal getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(BigDecimal percentChange) {
        this.percentChange = percentChange;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType == null ? null : coinType.trim();
    }
}