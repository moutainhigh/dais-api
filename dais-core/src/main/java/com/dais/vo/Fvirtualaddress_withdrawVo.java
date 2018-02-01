package com.dais.vo;

import com.dais.model.Fvirtualaddress_withdraw;

/**
 * @author GanZhen
 * @version 2017- 08- 16 17:11
 * @description
 * @copyright www.zhgtrade.com
 */
public class Fvirtualaddress_withdrawVo extends Fvirtualaddress_withdraw {

    private String coinLogo;
    private String coinName;

    public String getCoinLogo() {
        return coinLogo;
    }

    public void setCoinLogo(String coinLogo) {
        this.coinLogo = coinLogo;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
}
