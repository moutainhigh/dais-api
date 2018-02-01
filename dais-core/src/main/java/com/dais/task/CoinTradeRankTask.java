package com.dais.task;

import com.common.utils.CollectionUtils;
import com.common.utils.JsonUtils;
import com.dais.mapper.CoinTradeRankDayMapper;
import com.dais.mapper.CoinTradeRankHourMapper;
import com.dais.mapper.CoinTradeRankMapper;
import com.dais.mapper.CoinTradeRankMin5Mapper;
import com.dais.model.*;
import com.dais.service.VirtualCoinService;
import com.dais.utils.CoinTradeRankRquestUtil;
import com.dais.utils.JedisClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author xxp
 * @version 2017- 08- 10 19:35
 * @description
 * @copyright www.zhgtrade.com
 */
@Component
public class CoinTradeRankTask {
    private static Logger logger = Logger.getLogger(CoinTradeRankTask.class);

    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private CoinTradeRankMapper coinTradeRankMapper;
    @Autowired
    private CoinTradeRankMin5Mapper coinTradeRankMin5Mapper;
    @Autowired
    private CoinTradeRankHourMapper coinTradeRankHourMapper;
    @Autowired
    private CoinTradeRankDayMapper coinTradeRankDayMapper;
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
    @Value("${COIN_TRADE_RANK_XRP}")
    private String COIN_TRADE_RANK_XRP;
    @Value("${COIN_TRADE_RANK_BTS}")
    private String COIN_TRADE_RANK_BTS;
    @Value("${COIN_TRADE_RANK_EOS}")
    private String COIN_TRADE_RANK_EOS;
    @Value("${COIN_TRADE_RANK_QTUM}")
    private String COIN_TRADE_RANK_QTUM;



    public void run2() throws Exception{
        logger.info("开始获取交易行情数据");
        List<CoinTradeRank> ctrList = CoinTradeRankRquestUtil.requestJson();
        if(CollectionUtils.isEmpty(ctrList)){
            logger.error("定时任务获取交易行情出错");
            return ;
        }
        CoinTradeRank ctr = null;
        Fvirtualcointype fvct = null;
        FvirtualcointypeExample example = null;
        for (int i = 0; i < ctrList.size(); i++) {
            ctr = ctrList.get(i);
            if(null == ctr){
                continue;
            }
            ctr.setCoinType(ctr.getCoinType().toUpperCase());
            ctr.setTradeTime(System.currentTimeMillis()/1000);
            coinTradeRankMapper.insertSelective(ctr);
            //更新买入价格到币种表
            fvct = new Fvirtualcointype();
            fvct.setFopenprice(ctr.getBuy());
            example = new FvirtualcointypeExample();
            example.createCriteria().andFshortnameEqualTo(ctr.getCoinType().toUpperCase());
            virtualCoinServicev.updateVirtualCoinByExample(fvct,example);
            Object[] arr = initKlineData(ctr);

            //lpush作为Kline数据，set单条最新数据
            String lpushStr = JsonUtils.objectToJson(arr);
            if("btc".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_BTC, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_BTC+"_NewestRank", JsonUtils.objectToJson(ctr));
                //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
                if(caclKlineMin5(COIN_TRADE_RANK_BTC,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_BTC,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_BTC,ctr);
                    }
                }
            }else if("ltc".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_LTC, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_LTC+"_NewestRank", JsonUtils.objectToJson(ctr));
                if(caclKlineMin5(COIN_TRADE_RANK_LTC,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_LTC,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_LTC,ctr);
                    }
                }
            } else if("xrp".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_XRP, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_XRP+"_NewestRank", JsonUtils.objectToJson(ctr));
                //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
                if(caclKlineMin5(COIN_TRADE_RANK_XRP,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_XRP,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_XRP,ctr);
                    }
                }
            }else if("bcc".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_BCC, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_BCC+"_NewestRank", JsonUtils.objectToJson(ctr));
                //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
                if(caclKlineMin5(COIN_TRADE_RANK_BCC,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_BCC,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_BCC,ctr);
                    }
                }
            }else if("eth".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_ETH, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_ETH+"_NewestRank", JsonUtils.objectToJson(ctr));
                //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
                if(caclKlineMin5(COIN_TRADE_RANK_ETH,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_ETH,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_ETH,ctr);
                    }
                }
            }else if("etc".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_ETC, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_ETC+"_NewestRank", JsonUtils.objectToJson(ctr));
                //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
                if(caclKlineMin5(COIN_TRADE_RANK_ETC,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_ETC,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_ETC,ctr);
                    }
                }
            }else if("bts".equals(ctr.getCoinType())){
                jedisClient.lpush(COIN_TRADE_RANK_BTS, lpushStr);
                jedisClient.set(COIN_TRADE_RANK_BTS+"_NewestRank", JsonUtils.objectToJson(ctr));
                //写入间隔5分钟、一小时、一天K线，时间间隔与上一条最新纪录计算
                if(caclKlineMin5(COIN_TRADE_RANK_BTS,ctr)){
                    if(caclKlineHour(COIN_TRADE_RANK_BTS,ctr)){
                        caclKlineDay(COIN_TRADE_RANK_BTS,ctr);
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
    private boolean caclKlineMin5(String baseKey,CoinTradeRank nowCtr){
        try {
            CoinTradeRankMin5 ctrm5 = null;
            List<String> newestData = jedisClient.lrange(baseKey+"min5_kline",0,1);
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"min5_kline",JsonUtils.objectToJson(arr));
                ctrm5 = new CoinTradeRankMin5();
                ctrm5.setTradeTime(nowCtr.getTradeTime());
                ctrm5.setPriceFlu(nowCtr.getPriceFlu());
                ctrm5.setBuy(nowCtr.getBuy());
                ctrm5.setCoinType(nowCtr.getCoinType());
                ctrm5.setHigh(nowCtr.getHigh());
                ctrm5.setLast(nowCtr.getLast());
                ctrm5.setSell(nowCtr.getSell());
                ctrm5.setVol(nowCtr.getVol());
                coinTradeRankMin5Mapper.insertSelective(ctrm5);
                return true;
            }else{
                Object[] objectArr= JsonUtils.jsonToPojo(newestData.get(0),Object[].class);
                int times = (int)objectArr[0];
                long stepTime = (nowCtr.getTradeTime()-times)/60;//秒数除以60为分钟数
                if(stepTime >= 5){
                    ctrm5 = new CoinTradeRankMin5();
                    ctrm5.setTradeTime(nowCtr.getTradeTime());
                    ctrm5.setPriceFlu(nowCtr.getPriceFlu());
                    ctrm5.setBuy(nowCtr.getBuy());
                    ctrm5.setCoinType(nowCtr.getCoinType());
                    ctrm5.setHigh(nowCtr.getHigh());
                    ctrm5.setLast(nowCtr.getLast());
                    ctrm5.setSell(nowCtr.getSell());
                    ctrm5.setVol(nowCtr.getVol());
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
    private boolean caclKlineHour(String baseKey,CoinTradeRank nowCtr){
        try {
            List<String> newestData = jedisClient.lrange(baseKey+"hour_kline",0,1);
            CoinTradeRankHour ctrh = null;
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"hour_kline",JsonUtils.objectToJson(arr));
                ctrh = new CoinTradeRankHour();
                ctrh.setTradeTime(nowCtr.getTradeTime());
                ctrh.setPriceFlu(nowCtr.getPriceFlu());
                ctrh.setBuy(nowCtr.getBuy());
                ctrh.setCoinType(nowCtr.getCoinType());
                ctrh.setHigh(nowCtr.getHigh());
                ctrh.setLast(nowCtr.getLast());
                ctrh.setSell(nowCtr.getSell());
                ctrh.setVol(nowCtr.getVol());
                coinTradeRankHourMapper.insertSelective(ctrh);
                return true;
            }else{
                Object[] objectArr= JsonUtils.jsonToPojo(newestData.get(0),Object[].class);
                int times = (int)objectArr[0];
                long stepTime = (nowCtr.getTradeTime()-times)/60;//秒数除以60为分钟数
                if(stepTime >= 60){
                    ctrh = new CoinTradeRankHour();
                    ctrh.setTradeTime(nowCtr.getTradeTime());
                    ctrh.setPriceFlu(nowCtr.getPriceFlu());
                    ctrh.setBuy(nowCtr.getBuy());
                    ctrh.setCoinType(nowCtr.getCoinType());
                    ctrh.setHigh(nowCtr.getHigh());
                    ctrh.setLast(nowCtr.getLast());
                    ctrh.setSell(nowCtr.getSell());
                    ctrh.setVol(nowCtr.getVol());
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
    private boolean caclKlineDay(String baseKey,CoinTradeRank nowCtr){
        try {
            List<String> newestData = jedisClient.lrange(baseKey+"day_kline",0,1);
            CoinTradeRankDay ctrd = null;
            if(CollectionUtils.isEmpty(newestData)){
                Object[] arr = initKlineData(nowCtr);
                jedisClient.lpush(baseKey+"day_kline",JsonUtils.objectToJson(arr));
                ctrd = new CoinTradeRankDay();
                ctrd.setTradeTime(nowCtr.getTradeTime());
                ctrd.setPriceFlu(nowCtr.getPriceFlu());
                ctrd.setBuy(nowCtr.getBuy());
                ctrd.setCoinType(nowCtr.getCoinType());
                ctrd.setHigh(nowCtr.getHigh());
                ctrd.setLast(nowCtr.getLast());
                ctrd.setSell(nowCtr.getSell());
                ctrd.setVol(nowCtr.getVol());
                coinTradeRankDayMapper.insertSelective(ctrd);
                return true;
            }else{
                Object[] objectArr= JsonUtils.jsonToPojo(newestData.get(0),Object[].class);
                int times = (int)objectArr[0];
                long stepTime = (nowCtr.getTradeTime()-times)/60;//秒数除以60为分钟数
                if(stepTime >=60*24){
                    ctrd = new CoinTradeRankDay();
                    ctrd.setTradeTime(nowCtr.getTradeTime());
                    ctrd.setPriceFlu(nowCtr.getPriceFlu());
                    ctrd.setBuy(nowCtr.getBuy());
                    ctrd.setCoinType(nowCtr.getCoinType());
                    ctrd.setHigh(nowCtr.getHigh());
                    ctrd.setLast(nowCtr.getLast());
                    ctrd.setSell(nowCtr.getSell());
                    ctrd.setVol(nowCtr.getVol());
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

    private Object[] initKlineData(CoinTradeRank ctr){
        if(ctr == null){
            return null;
        }
        Object[] arr = new Object[8];
        arr[0]= ctr.getTradeTime();
        arr[1]= 0;
        arr[2] = 0;
        arr[3] = ctr.getBuy();
        arr[4] = ctr.getSell();
        arr[5] = ctr.getHigh();
        arr[6] = ctr.getLow();
        arr[7] = ctr.getVol();
        return arr;
    }

    public static void main(String[] args) {
        long a = 5;
        System.out.println(a<5.5);
    }

}
