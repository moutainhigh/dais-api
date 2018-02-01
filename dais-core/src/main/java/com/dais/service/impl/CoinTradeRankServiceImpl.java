package com.dais.service.impl;

import com.common.pojo.ResultModel;
import com.common.utils.CollectionUtils;
import com.common.utils.JsonUtils;
import com.dais.mapper.CoinTradeRankMapper;
import com.dais.model.CoinTradeRank;
import com.dais.model.CoinTradeRankExample;
import com.dais.model.Fvirtualcointype;
import com.dais.model.FvirtualcointypeExample;
import com.dais.service.CoinTradeRankService;
import com.dais.service.VirtualCoinService;
import com.dais.utils.JedisClient;
import com.dais.vo.FvitualCoinTradeRankVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.common.utils.JsonUtils.jsonToPojo;

/**
 * @author xxp
 * @version 2017- 08- 10 20:37
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class CoinTradeRankServiceImpl implements CoinTradeRankService {
    private static Logger logger = Logger.getLogger(CoinTradeRankServiceImpl.class);

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private CoinTradeRankMapper coinTradeRankMapper;
    @Autowired
    private VirtualCoinService virtualCoinService;

    @Value("${COIN_TRADE_RANK_BTC}")
    private String COIN_TRADE_RANK_BTC;
    @Value("${COIN_TRADE_RANK_LTC}")
    private String COIN_TRADE_RANK_LTC;
    @Value("${COIN_TRADE_RANK_BCC}")
    private String COIN_TRADE_RANK_BCC;
    @Value("${COIN_TRADE_RANK_ETH}")
    private String COIN_TRADE_RANK_ETH;
    @Value("${COIN_TRADE_RANK_ETC}")
    private String COIN_TRADE_RANK_ETC;
    @Value("${COIN_TRADE_RANK_XRP}")
    private String COIN_TRADE_RANK_XRP;
    @Value("${COIN_TRADE_RANK_BTS}")
    private String COIN_TRADE_RANK_BTS;
    @Value("${COIN_TRADE_RANK_EOS}")
    private String COIN_TRADE_RANK_EOS;
    @Value("${COIN_TRADE_RANK_QTUM}")
    private String COIN_TRADE_RANK_QTUM;

    @Override
    public ResultModel getNewestRank() {
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        example.createCriteria().andFiswithdrawEqualTo(true);
        List<Fvirtualcointype> fvctList = virtualCoinService.selectByExample(example);
        Iterator<Fvirtualcointype> it = fvctList.iterator();
        Fvirtualcointype fvct = null;
        FvitualCoinTradeRankVo ctrv = null;
        List<FvitualCoinTradeRankVo> list = new ArrayList<>();
        while (it.hasNext()) {
            try {
                fvct = it.next();
                ctrv = null;
                if ("BTC".equals(fvct.getFshortname())) {
                    ctrv = jsonToPojo(jedisClient.get(COIN_TRADE_RANK_BTC + "_NewestRank"), FvitualCoinTradeRankVo.class);
                    ctrv.setWebSource("okex.com");
                } else if ("LTC".equals(fvct.getFshortname())) {
                    ctrv = jsonToPojo(jedisClient.get(COIN_TRADE_RANK_LTC + "_NewestRank"), FvitualCoinTradeRankVo.class);
                    ctrv.setWebSource("okex.com");
                }else  if ("BCC".equals(fvct.getFshortname())) {
                    ctrv = jsonToPojo(jedisClient.get(COIN_TRADE_RANK_BCC + "_NewestRank"), FvitualCoinTradeRankVo.class);
                    ctrv.setWebSource("okex.com");
                }else if ("ETH".equals(fvct.getFshortname())) {
                    ctrv = jsonToPojo(jedisClient.get(COIN_TRADE_RANK_ETH + "_NewestRank"), FvitualCoinTradeRankVo.class);
                    ctrv.setWebSource("okex.com");
                }else if ("ETC".equals(fvct.getFshortname())) {
                    ctrv = jsonToPojo(jedisClient.get(COIN_TRADE_RANK_ETC + "_NewestRank"), FvitualCoinTradeRankVo.class);
                    ctrv.setWebSource("okex.com");
                }
                if (ctrv != null) {
                    ctrv.setCoinName(fvct.getFname());
                    ctrv.setCoinLogo(fvct.getFurl());
                    list.add(ctrv);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResultModel.ok(list);
    }

    private String caclPriceFul(String baseKey) {
        List<String> list = jedisClient.lrange(baseKey + "day_kline", 0, 1);
        if (CollectionUtils.isEmpty(list) || list.size() < 2) {
            return 0.00 + "%";
        }
        Object[] arr = JsonUtils.jsonToPojo(list.get(0), Object[].class);
        Object[] arr2 = JsonUtils.jsonToPojo(list.get(0), Object[].class);

        return (Double.valueOf(arr2[3] + "") - Double.valueOf(arr[3] + "")) / Double.valueOf(arr[3] + "") * 100 + "%";
    }

    @Override
    public ResultModel getNewestRankByCoinType(String coinType) {
        String ctrStr = null;
        if ("BTC".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_BTC + "_NewestRank");
        } else if ("LTC".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_LTC + "_NewestRank");
        } else if ("XRP".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_XRP + "_NewestRank");
        } else if ("BCC".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_BCC + "_NewestRank");
        } else if ("ETH".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_ETH + "_NewestRank");
        } else if ("ETC".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_ETC + "_NewestRank");
        } else if ("BTS".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_BTS + "_NewestRank");
        } else if ("QTUM".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_QTUM + "_NewestRank");
        } else if ("EOS".equals(coinType)) {
            ctrStr = jedisClient.get(COIN_TRADE_RANK_EOS + "_NewestRank");
        }
        FvitualCoinTradeRankVo ctrv = jsonToPojo(ctrStr, FvitualCoinTradeRankVo.class);
        FvirtualcointypeExample example = new FvirtualcointypeExample();
        example.createCriteria().andFshortnameEqualTo(ctrv.getCoinType());
        List<Fvirtualcointype> fvctList = virtualCoinService.selectByExample(example);
        if (CollectionUtils.isEmpty(fvctList)) {
        } else {
            ctrv.setCoinName(fvctList.get(0).getFname());
            ctrv.setCoinLogo(fvctList.get(0).getFurl());
        }
        //计算涨跌幅
        return ResultModel.ok(ctrv);
    }


    /**
     * timeType k线数据分钟数
     *
     * @param coinType
     * @param timeType
     * @return
     */
    @Override
    public ResultModel getKlineByCoin(String coinType, String timeType) {
        //day hour min5 min1
        List<String> list = null;
        if ("BTC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_BTC, timeType);
        } else if ("LTC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_LTC, timeType);
        } else if ("XRP".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_XRP, timeType);
        } else if ("BCC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_BCC, timeType);
        } else if ("ETH".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_ETH, timeType);
        } else if ("ETC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_ETC, timeType);
        } else if ("BTS".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_BTS, timeType);
        } else if ("QTUM".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_QTUM, timeType);
        } else if ("EOS".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_EOS, timeType);
        }
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.build(400, "暂时没有数据");
        } else {
            List<String[]> list2 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                list2.add(JsonUtils.jsonToPojo(list.get(i), String[].class));
            }
            return ResultModel.ok(list2);
        }
    }

    /**
     * timeType k线数据分钟数
     *
     * @param coinType
     * @return
     */
    @Override
    public List<Object> getPriceByCoin(String coinType) {
        //day hour min5 min1
        List<String> list = null;
        if ("BTC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_BTC);
        } else if ("LTC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_LTC);
        } else if ("XRP".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_XRP);
        } else if ("BCC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_BCC);
        } else if ("ETH".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_ETH);
        } else if ("ETC".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_ETC);
        } else if ("BTS".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_BTS);
        } else if ("QTUM".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_QTUM);
        } else if ("EOS".equals(coinType)) {
            list = this.getRedisKlineData(COIN_TRADE_RANK_EOS);
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            List<Object> list2 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Object[] arr =  JsonUtils.jsonToPojo(list.get(i), Object[].class);
                Object[] tempArr = new Object[2];
                tempArr[0] = arr[0];
                tempArr[1] = arr[3];
                list2.add(tempArr);
            }
            return list2;
        }
    }

    @Override
    public ResultModel getCoinTradeRank(int pageNo, int rows) {
        CoinTradeRankExample example = new CoinTradeRankExample();
        CoinTradeRankExample.Criteria criteria = example.createCriteria();
        criteria.andCoinTypeEqualTo("btc");
//        criteria.andHighLessThan(1.2);
//        example.setOrderByClause("high desc");
        PageHelper.startPage(pageNo, rows);
        List<CoinTradeRank> itemList = coinTradeRankMapper.selectByExample(example);
        PageInfo<CoinTradeRank> pageInfo = new PageInfo<>(itemList);
        return ResultModel.build(200, "OK", pageInfo);
    }

    private List<String> getRedisKlineData(String baseKey, String timeType) {
        List<String> list = null;
        if ("day".equals(timeType)) {
            list = jedisClient.lrange(baseKey + "day_kline", 0, 800);
        } else if ("hour".equals(timeType)) {
            list = jedisClient.lrange(baseKey + "hour_kline", 0, 800);
        } else if ("min5".equals(timeType)) {
            list = jedisClient.lrange(baseKey + "min5_kline", 0, 800);
        } else {
            list = jedisClient.lrange(baseKey, 0, 800);
        }
        return list;
    }

    private List<String> getRedisKlineData(String baseKey) {
        return jedisClient.lrange(baseKey + "hour_kline", 0, 23);
    }


}
