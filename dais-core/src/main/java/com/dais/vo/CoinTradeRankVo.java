package com.dais.vo;

import com.dais.model.CoinTradeRank;

/**
 * @author xxp
 * @version 2017- 08- 16 15:17
 * @description
 * @copyright www.zhgtrade.com
 */
public class CoinTradeRankVo extends CoinTradeRank{

    private String coinName;

    private String coinLogo;

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
}
