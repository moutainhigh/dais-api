package com.dais.task;

import com.alibaba.fastjson.JSONObject;
import com.common.utils.CollectionUtils;
import com.common.utils.ConstantKeys;
import com.common.utils.HttpClientUtils;
import com.common.utils.JsonUtils;
import com.dais.mapper.CoinTradeRankDayMapper;
import com.dais.mapper.CoinTradeRankHourMapper;
import com.dais.mapper.CoinTradeRankMin5Mapper;
import com.dais.mapper.FvitualCoinTradeRankMapper;
import com.dais.model.*;
import com.dais.service.VirtualCoinService;
import com.dais.utils.CoinTradeRankRquestUtil;
import com.dais.utils.JedisClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.common.utils.JsonUtils.jsonToPojo;
import static com.dais.utils.CoinTradeRankRquestUtil.scale;


/**
 * @author xxp
 * @version 2017- 08- 10 19:35
 * @description
 * @copyright www.zhgtrade.com
 */
@Component
public class CoinTradeRankTask3 {
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private VirtualCoinService virtualCoinServicev;

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

    /**
     * 定时执行的方法
     * 负责获取交易行情数据保存数据库
     * 保存redis
     * @throws Exception
     */
   public void run() throws Exception {
       System.out.println("开始同步最新行情数据****");
       double rate = 6.6;
       try {
           String rateResponse = HttpClientUtils.get("https://www.okex.com/api/v1/exchange_rate.do");
//           System.out.println(rateResponse);
           rate = Double.valueOf(((Map) JSONObject.parse(rateResponse)).get("rate").toString());
       } catch (Exception e) {
           e.printStackTrace();
       }

       FvitualCoinTradeRank fvitualCoinTradeRank = null;
       Fvirtualcointype fvirtualcointype = null;
       FvirtualcointypeExample example = null;
       String[] arr = {"btc","bch","ltc","etc","eth"};
       for (int i = 0; i < arr.length; i++) {
           try {
               String response = HttpClientUtils.get("https://www.okex.com/api/v1/ticker.do?symbol=" + arr[i] + "_usdt");
//               System.out.println(response);
               Map object = (Map) JSONObject.parse(response);
               System.out.println(object);
//               System.out.println("***************************"+object.get("ticker")+"************************");
               Map map = (Map) JSONObject.parse(object.get("ticker").toString());
               fvitualCoinTradeRank = new FvitualCoinTradeRank();
               fvitualCoinTradeRank.setBasevolume(scale(Double.valueOf(map.get("vol").toString())));
               fvitualCoinTradeRank.setHigh24hr(scale(Double.valueOf(map.get("high").toString()) * rate));
               fvitualCoinTradeRank.setLast(scale(Double.valueOf(map.get("last").toString()) * rate));
               fvitualCoinTradeRank.setLow24hr(scale(Double.valueOf(map.get("low").toString()) * rate));
               fvitualCoinTradeRank.setHighestBid(scale(Double.valueOf(map.get("buy").toString()) * rate));
               fvitualCoinTradeRank.setLowestAsk(scale(Double.valueOf(map.get("sell").toString()) * rate));

               List<String> strings = new ArrayList<>();
               try{
                   strings = jedisClient.lrange("coin_percentChange_"+arr[i],400,400);
               }catch (Exception e){
               }
               fvitualCoinTradeRank.setPercentChange(new BigDecimal(0));
               if(!CollectionUtils.isEmpty(strings)){
                   FvitualCoinTradeRank f = JsonUtils.jsonToPojo(strings.get(0),FvitualCoinTradeRank.class);
                   if(f != null){
                       BigDecimal p =  (fvitualCoinTradeRank.getLowestAsk().subtract(f.getLowestAsk())).divide(f.getLowestAsk(),2);
                       fvitualCoinTradeRank.setPercentChange(p.multiply(new BigDecimal(100)));
                   }
               }
               jedisClient.lpush("coin_percentChange_"+arr[i],JsonUtils.objectToJson(fvitualCoinTradeRank));
               jedisClient.ltrim("coin_percentChange_"+arr[i],0,400);
               fvitualCoinTradeRank.setCoinType(arr[i].toUpperCase());
                if(arr[i].toUpperCase().equals("BCH")){
                    fvitualCoinTradeRank.setCoinType("BCC");
                }
               fvitualCoinTradeRank.setTradeTime(System.currentTimeMillis() / 1000);
               //更新买入价格到币种表
               fvirtualcointype = new Fvirtualcointype();
               fvirtualcointype.setFopenprice(fvitualCoinTradeRank.getHighestBid());
               example = new FvirtualcointypeExample();
               example.createCriteria().andFshortnameEqualTo(fvitualCoinTradeRank.getCoinType());
               virtualCoinServicev.updateVirtualCoinByExample(fvirtualcointype, example);

               if ("BTC".equals(fvitualCoinTradeRank.getCoinType())) {
                   jedisClient.set(COIN_TRADE_RANK_BTC + "_NewestRank", JsonUtils.objectToJson(fvitualCoinTradeRank));
                   caclKlineHour(COIN_TRADE_RANK_BTC,fvitualCoinTradeRank);
               } else if ("LTC".equals(fvitualCoinTradeRank.getCoinType())) {
                   jedisClient.set(COIN_TRADE_RANK_LTC + "_NewestRank", JsonUtils.objectToJson(fvitualCoinTradeRank));
                   caclKlineHour(COIN_TRADE_RANK_LTC,fvitualCoinTradeRank);
               } else if ("BCC".equals(fvitualCoinTradeRank.getCoinType())) {
                   jedisClient.set(COIN_TRADE_RANK_BCC + "_NewestRank", JsonUtils.objectToJson(fvitualCoinTradeRank));
                   caclKlineHour(COIN_TRADE_RANK_BCC,fvitualCoinTradeRank);
               } else if ("ETH".equals(fvitualCoinTradeRank.getCoinType())) {
                   jedisClient.set(COIN_TRADE_RANK_ETH + "_NewestRank", JsonUtils.objectToJson(fvitualCoinTradeRank));
                   caclKlineHour(COIN_TRADE_RANK_ETH,fvitualCoinTradeRank);
               } else if ("ETC".equals(fvitualCoinTradeRank.getCoinType())) {
                   jedisClient.set(COIN_TRADE_RANK_ETC + "_NewestRank", JsonUtils.objectToJson(fvitualCoinTradeRank));
                   caclKlineHour(COIN_TRADE_RANK_ETC,fvitualCoinTradeRank);
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }

    /**
     * 计算间隔1小时K线
     * @param baseKey
     * @param nowCtr
     * @return
     */
    private boolean caclKlineHour(String baseKey,FvitualCoinTradeRank nowCtr){
        try {
            List<String> newestData = null;
            try{
                newestData = jedisClient.lrange(baseKey+"hour_kline",0,1);
            }catch (Exception e){
            }
            CoinTradeRankHour ctrh = null;
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"hour_kline",JsonUtils.objectToJson(arr));
                jedisClient.ltrim(baseKey+"hour_kline",0,24);
                return true;
            }else{
                Object[] objectArr= JsonUtils.jsonToPojo(newestData.get(0),Object[].class);
                int times = (int)objectArr[0];
                long stepTime = (nowCtr.getTradeTime()-times)/60;//秒数除以60为分钟数
                if(stepTime >= 60){
                    ctrh = new CoinTradeRankHour();
                    ctrh.setTradeTime(nowCtr.getTradeTime());
                    ctrh.setPriceFlu(nowCtr.getPercentChange()+"");
                    ctrh.setBuy(nowCtr.getHighestBid());
                    ctrh.setCoinType(nowCtr.getCoinType());
                    ctrh.setHigh(nowCtr.getHigh24hr());
                    ctrh.setLast(nowCtr.getLast());
                    ctrh.setSell(nowCtr.getLowestAsk());
                    ctrh.setVol(nowCtr.getBasevolume());
                    Object[] arr = initKlineData(nowCtr);
                    jedisClient.lpush(baseKey+"hour_kline",JsonUtils.objectToJson(arr));
                    jedisClient.ltrim(baseKey+"hour_kline",0,24);
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private Object[] initKlineData(FvitualCoinTradeRank fctr){
        if(fctr == null){
            return null;
        }
        Object[] arr = new Object[8];
        arr[0]= fctr.getTradeTime();
        arr[1]= 0;
        arr[2] = 0;
        arr[3] = fctr.getHighestBid();
        arr[4] = fctr.getLowestAsk();
        arr[5] = fctr.getHigh24hr();
        arr[6] = fctr.getLow24hr();
        arr[7] = fctr.getQuotevolume();
        return arr;
    }

    public static void main(String[] args) {
        String a = "{\"date\":\"1511437430\",\"ticker\":{\"high\":\"8375.00\",\"vol\":\"2031.51\",\"last\":\"8172.72\",\"low\":\"8120.00\",\"buy\":\"8172.70\",\"sell\":\"8172.71\"}}";
        Map object = (Map) JSONObject.parse(a);
        System.out.println("***************************"+object.get("ticker")+"************************");
        Map map = (Map) JSONObject.parse(object.get("ticker").toString());
    }
}


