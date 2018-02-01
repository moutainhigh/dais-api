package com.dais.vo;

/**
 * @author GanZhen
 * @version 2017- 08- 17 10:25
 * @description
 * @copyright www.zhgtrade.com
 */
public class FvitualCoinTradeRankVo{
    private Integer id;

    private String highestBid;

    private String lowestAsk;

    private String last;

    private String quotevolume;

    private String basevolume;

    private String low24hr;

    private String high24hr;

    private Long tradeTime;

    private String percentChange;

    private String coinType;

    private String coinName;

    private String coinLogo;

    private String webSource;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinLogo() {
        return coinLogo;
    }

    public void setCoinLogo(String coinLogo) {
        this.coinLogo = coinLogo;
    }

    public String getWebSource() {
        return webSource;
    }

    public void setWebSource(String webSource) {
        this.webSource = webSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getQuotevolume() {
        return quotevolume;
    }

    public void setQuotevolume(String quotevolume) {
        this.quotevolume = quotevolume;
    }

    public String getBasevolume() {
        return basevolume;
    }

    public void setBasevolume(String basevolume) {
        this.basevolume = basevolume;
    }

    public String getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(String low24hr) {
        this.low24hr = low24hr;
    }

    public String getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(String high24hr) {
        this.high24hr = high24hr;
    }

    public Long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }
}
