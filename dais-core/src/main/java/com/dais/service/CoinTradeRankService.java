package com.dais.service;

import com.common.pojo.ResultModel;

import java.util.List;

/**
 * @author GanZhen
 * @version 2017- 08- 10 20:28
 * @description
 * @copyright www.zhgtrade.com
 */
public interface CoinTradeRankService {

    public ResultModel getNewestRank();

    public ResultModel getNewestRankByCoinType(String coinType);

    public ResultModel getKlineByCoin(String coin, String timeType);

    public List<Object> getPriceByCoin(String coinType);

    public ResultModel getCoinTradeRank(int pageNo, int rows);
}
