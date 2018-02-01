package com.dais.task;

import com.common.utils.CollectionUtils;
import com.common.utils.JsonUtils;
import com.dais.mapper.*;
import com.dais.model.*;
import com.dais.service.VirtualCoinService;
import com.dais.utils.CoinTradeRankRquestUtil;
import com.dais.utils.JedisClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author xxp
 * @version 2017- 08- 10 19:35
 * @description
 * @copyright www.zhgtrade.com
 */
@Component
public class CoinTradeRankTask2 {
    private static Logger logger = Logger.getLogger(CoinTradeRankTask2.class);

    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private CoinTradeRankMin5Mapper coinTradeRankMin5Mapper;
    @Autowired
    private CoinTradeRankHourMapper coinTradeRankHourMapper;
    @Autowired
    private CoinTradeRankDayMapper coinTradeRankDayMapper;
    @Autowired
    private VirtualCoinService virtualCoinServicev;
    @Autowired
    private FvitualCoinTradeRankMapper fvitualCoinTradeRankMapper;

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

    /**
     * 定时执行的方法
     * 负责获取交易行情数据保存数据库
     * 保存redis
     * @throws Exception
     */
   public void run() throws Exception{

       logger.info("开始获取交易行情数据");
       List<FvitualCoinTradeRank> fctrList = CoinTradeRankRquestUtil.requestJson2();
       if(CollectionUtils.isEmpty(fctrList)){
           logger.error("定时任务获取交易行情出错");
           return ;
       }
       FvitualCoinTradeRank fctr = null;
       Fvirtualcointype fvct = null;
       FvirtualcointypeExample example = null;
       for (int i = 0; i < fctrList.size(); i++) {
            fctr = fctrList.get(i);
           if(null == fctr){
               continue;
           }
           fctr.setCoinType(fctr.getCoinType().toUpperCase());
           fctr.setTradeTime(System.currentTimeMillis()/1000);
           fvitualCoinTradeRankMapper.insertSelective(fctr);
           //更新买入价格到币种表
           fvct = new Fvirtualcointype();
           fvct.setFopenprice(fctr.getHighestBid());
           example = new FvirtualcointypeExample();
           example.createCriteria().andFshortnameEqualTo(fctr.getCoinType().toUpperCase());
           virtualCoinServicev.updateVirtualCoinByExample(fvct,example);
           Object[] arr = initKlineData(fctr);

           //lpush作为Kline数据，set单条最新数据
           String lpushStr = JsonUtils.objectToJson(arr);
           if("BTC".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_BTC)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_BTC, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_BTC+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_BTC,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_BTC,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_BTC,fctr);
                   }
               }
           }else if("LTC".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_LTC)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_LTC, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_LTC+"_NewestRank", JsonUtils.objectToJson(fctr));
               if(caclKlineMin5(COIN_TRADE_RANK_LTC,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_LTC,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_LTC,fctr);
                   }
               }
           } else if("XRP".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_XRP)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_XRP, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_XRP+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_XRP,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_XRP,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_XRP,fctr);
                   }
               }
           }else if("BCC".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_BCC)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_BCC, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_BCC+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_BCC,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_BCC,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_BCC,fctr);
                   }
               }
           }else if("ETH".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_ETH)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_ETH, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_ETH+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_ETH,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_ETH,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_ETH,fctr);
                   }
               }
           }else if("ETC".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_ETC)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_ETC, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_ETC+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_ETC,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_ETC,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_ETC,fctr);
                   }
               }
           }else if("BTS".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_BTS)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_BTS, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_BTS+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_BTS,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_BTS,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_BTS,fctr);
                   }
               }
           }else if("EOS".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_EOS)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_EOS, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_EOS+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_EOS,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_EOS,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_EOS,fctr);
                   }
               }
           }else if("QTUM".equals(fctr.getCoinType())){
               if(!checkIsChange(fctr.getQuotevolume(),COIN_TRADE_RANK_QTUM)){
                   return;
               }
               jedisClient.lpush(COIN_TRADE_RANK_QTUM, lpushStr);
               jedisClient.set(COIN_TRADE_RANK_QTUM+"_NewestRank", JsonUtils.objectToJson(fctr));
               //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
               if(caclKlineMin5(COIN_TRADE_RANK_QTUM,fctr)){
                   if(caclKlineHour(COIN_TRADE_RANK_QTUM,fctr)){
                       caclKlineDay(COIN_TRADE_RANK_QTUM,fctr);
                   }
               }
           }
       }
   }



    /**
     * 计算间隔5分钟k线
     * @param baseKey
     * @param nowCtr
     * @return
     */
    private boolean caclKlineMin5(String baseKey,FvitualCoinTradeRank nowCtr){
        try {
            CoinTradeRankMin5 ctrm5 = null;
            List<String> newestData = jedisClient.lrange(baseKey+"min5_kline",0,1);
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"min5_kline",JsonUtils.objectToJson(arr));
                ctrm5 = new CoinTradeRankMin5();
                ctrm5.setTradeTime(nowCtr.getTradeTime());
                ctrm5.setPriceFlu(nowCtr.getPercentChange()+"");
                ctrm5.setBuy(nowCtr.getHighestBid());
                ctrm5.setCoinType(nowCtr.getCoinType());
                ctrm5.setHigh(nowCtr.getHigh24hr());
                ctrm5.setLast(nowCtr.getLast());
                ctrm5.setSell(nowCtr.getLowestAsk());
                ctrm5.setVol(nowCtr.getBasevolume());
                coinTradeRankMin5Mapper.insertSelective(ctrm5);
                return true;
            }else{
                Object[] objectArr= JsonUtils.jsonToPojo(newestData.get(0),Object[].class);
                int times = (int)objectArr[0];
                long stepTime = (nowCtr.getTradeTime()-times)/60;//秒数除以60为分钟数
                if(stepTime >= 5){
                    ctrm5 = new CoinTradeRankMin5();
                    ctrm5.setTradeTime(nowCtr.getTradeTime());
                    ctrm5.setPriceFlu(nowCtr.getPercentChange()+"");
                    ctrm5.setBuy(nowCtr.getHighestBid());
                    ctrm5.setCoinType(nowCtr.getCoinType());
                    ctrm5.setHigh(nowCtr.getHigh24hr());
                    ctrm5.setLast(nowCtr.getLast());
                    ctrm5.setSell(nowCtr.getLowestAsk());
                    ctrm5.setVol(nowCtr.getBasevolume());
                    coinTradeRankMin5Mapper.insertSelective(ctrm5);
                    Object[] arr = initKlineData(nowCtr);
                    jedisClient.lpush(baseKey+"min5_kline",JsonUtils.objectToJson(arr));
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("定时任务计算5分钟K闲数据出错"+e);
            return false;
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
            this.delData();
            List<String> newestData = jedisClient.lrange(baseKey+"hour_kline",0,1);
            CoinTradeRankHour ctrh = null;
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"hour_kline",JsonUtils.objectToJson(arr));
                ctrh = new CoinTradeRankHour();
                ctrh.setTradeTime(nowCtr.getTradeTime());
                ctrh.setPriceFlu(nowCtr.getPercentChange()+"");
                ctrh.setBuy(nowCtr.getHighestBid());
                ctrh.setCoinType(nowCtr.getCoinType());
                ctrh.setHigh(nowCtr.getHigh24hr());
                ctrh.setLast(nowCtr.getLast());
                ctrh.setSell(nowCtr.getLowestAsk());
                ctrh.setVol(nowCtr.getBasevolume());
                coinTradeRankHourMapper.insertSelective(ctrh);
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
                    coinTradeRankHourMapper.insertSelective(ctrh);
                    Object[] arr = initKlineData(nowCtr);
                    jedisClient.lpush(baseKey+"hour_kline",JsonUtils.objectToJson(arr));
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("定时任务计算一小时K线任务出错"+e);
            return false;
        }
    }

    /**
     * 计算日K线
     * @param baseKey
     * @param nowCtr
     * @return
     */
    private boolean caclKlineDay(String baseKey,FvitualCoinTradeRank nowCtr){
        try {
            List<String> newestData = jedisClient.lrange(baseKey+"day_kline",0,1);
            CoinTradeRankDay ctrd = null;
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"day_kline",JsonUtils.objectToJson(arr));
                ctrd = new CoinTradeRankDay();
                ctrd.setTradeTime(nowCtr.getTradeTime());
                ctrd.setPriceFlu(nowCtr.getPercentChange()+"");
                ctrd.setBuy(nowCtr.getHighestBid());
                ctrd.setCoinType(nowCtr.getCoinType());
                ctrd.setHigh(nowCtr.getHigh24hr());
                ctrd.setLast(nowCtr.getLast());
                ctrd.setSell(nowCtr.getLowestAsk());
                ctrd.setVol(nowCtr.getBasevolume());
                coinTradeRankDayMapper.insertSelective(ctrd);
                return true;
            }else{
                Object[] objectArr= JsonUtils.jsonToPojo(newestData.get(0),Object[].class);
                int times = (int)objectArr[0];
                long stepTime = (nowCtr.getTradeTime()-times)/60;//秒数除以60为分钟数
                if(stepTime >=60*24){
                    ctrd = new CoinTradeRankDay();
                    ctrd.setTradeTime(nowCtr.getTradeTime());
                    ctrd.setPriceFlu(nowCtr.getPercentChange()+"");
                    ctrd.setBuy(nowCtr.getHighestBid());
                    ctrd.setCoinType(nowCtr.getCoinType());
                    ctrd.setHigh(nowCtr.getHigh24hr());
                    ctrd.setLast(nowCtr.getLast());
                    ctrd.setSell(nowCtr.getLowestAsk());
                    ctrd.setVol(nowCtr.getBasevolume());
                    coinTradeRankDayMapper.insertSelective(ctrd);
                    Object[] arr = initKlineData(nowCtr);
                    jedisClient.lpush(baseKey+"day_kline",JsonUtils.objectToJson(arr));
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("定时任务计算日K线任务出错"+e);
            return false;
        }

    }

    private boolean checkIsChange(BigDecimal quotevolume, String baseKey){
        FvitualCoinTradeRank fctr = JsonUtils.jsonToPojo(jedisClient.get(baseKey+"_NewestRank"),FvitualCoinTradeRank.class);
        if(fctr == null){
            return true;
        }
        if(quotevolume.equals(fctr.getQuotevolume())){
            return false;
        }else{
            return true;
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
        long a = 5;
        System.out.println(a<5.5);
    }

    public void delData(){
        System.out.println("***************清除缓存**********");
        jedisClient.ltrim(COIN_TRADE_RANK_BTC,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_LTC,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BCC,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETH,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETC,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_XRP,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BTS,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_EOS,0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_QTUM,0,800);

        jedisClient.ltrim(COIN_TRADE_RANK_BTC+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_LTC+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BCC+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETH+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETC+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_XRP+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BTS+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_EOS+"min5_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_QTUM+"min5_kline",0,800);

        jedisClient.ltrim(COIN_TRADE_RANK_BTC+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_LTC+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BCC+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETH+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETC+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_XRP+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BTS+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_EOS+"hour_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_QTUM+"hour_kline",0,800);

       /* jedisClient.ltrim(COIN_TRADE_RANK_BTC+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_LTC+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BCC+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETH+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_ETC+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_XRP+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_BTS+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_EOS+"day_kline",0,800);
        jedisClient.ltrim(COIN_TRADE_RANK_QTUM+"day_kline",0,800);*/
    }

}
