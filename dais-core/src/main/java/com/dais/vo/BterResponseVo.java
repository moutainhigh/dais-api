package com.dais.vo;


/**
 * @author xxp
 * @version 2017- 08- 16 19:53
 * @description
 * @copyright www.zhgtrade.com
 */
public class BterResponseVo {
    private Double last;
    private Double lowestAsk;
    private Double highestBid;
    private Double percentChange;
    private Double baseVolume;//成交额
    private Double quoteVolume;//成交量
    private Double high24hr;
    private Double low24hr;
    private String result;

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(Double lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public Double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(Double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public Double getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(Double quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Double getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(Double high24hr) {
        this.high24hr = high24hr;
    }

    public Double getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(Double low24hr) {
        this.low24hr = low24hr;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
