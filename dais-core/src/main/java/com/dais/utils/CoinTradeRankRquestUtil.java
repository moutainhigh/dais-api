package com.dais.utils;

import com.common.utils.HttpClientUtils;
import com.common.utils.JsonUtils;
import com.dais.model.CoinTradeRank;
import com.dais.model.FvitualCoinTradeRank;
import com.dais.vo.BterResponseVo;
import org.apache.http.client.methods.HttpPost;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.common.utils.JsonUtils.jsonToPojo;

/**
 * @author xxp
 * @version 2017- 08- 10 18:28
 * @description
 * @copyright www.zhgtrade.com
 */
public class CoinTradeRankRquestUtil {

    public static List<CoinTradeRank> requestJson(){
        String userAgent = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_2 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8H7 Safari/6533.18.5";
        HttpPost post = new HttpPost("http://api.btc38.com/v1/ticker.php?c=all&mk_type=cny");
        post.setHeader("User-Agent",userAgent);
        String json = HttpClientUtils.execute(post,"utf-8");
        //保存接口返回的所有数据
        String[] arr = json.split("},");
        List<String> list = new ArrayList<>();
        //过滤多余的数据
        for (int i=0;i<arr.length;i++) {
            if(arr[i].indexOf("btc") > -1 || arr[i].indexOf("ltc") > -1
                    || arr[i].indexOf("bcc") > -1 || arr[i].indexOf("eth") > -1
                    || arr[i].indexOf("etc") > -1 || arr[i].indexOf("xrp") > -1
                    || arr[i].indexOf("bts") > -1){
                list.add(arr[i]);
            }
        }
        //格式化数据
        List<String> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            String jsonStr = list.get(i);
            String coinType = "\"coinType\":"+jsonStr.substring(0,jsonStr.indexOf(":{\"ticker\":")).replace("{","")+"}";
            String  content = jsonStr.substring(jsonStr.indexOf("{\"ticker\":")+"{\"ticker\":".length()).replace("}","");
            list2.add(content+","+coinType);
        }
        //json数据转换java对象
        List<CoinTradeRank> listCtr = new ArrayList<>();
        for (int i=0;i<list2.size();i++) {
            System.out.println(list2.get(i));
            listCtr.add(jsonToPojo(list2.get(i),CoinTradeRank.class));
        }
        return listCtr;
    }

    public static List<FvitualCoinTradeRank> requestJson2(){
//        String[] arr = {"btc", "ltc", "xrp", "bcc" ,"qtum" ,"bts" ,"eth", "etc" ,"eos"};
        String[] arr = {"btc", "ltc", "bcc" ,"eth", "etc" };
        List<FvitualCoinTradeRank> list = new ArrayList<>();
        String json = "";
        BterResponseVo brv = null;
        FvitualCoinTradeRank fvcr = null;
        for (int i = 0; i < arr.length; i++) {
            try {
                json = HttpClientUtils.get("http://data.bter.com/api2/1/ticker/"+arr[i]+"_cny");
                brv = JsonUtils.jsonToPojo(json, BterResponseVo.class);
                fvcr = new FvitualCoinTradeRank();
                fvcr.setBasevolume(scale(brv.getBaseVolume()));
                fvcr.setHigh24hr(scale(brv.getHigh24hr()));
                fvcr.setHighestBid(scale(brv.getHighestBid()));
                fvcr.setLast(scale(brv.getLast()));
                fvcr.setLow24hr(scale(brv.getLow24hr()));
                fvcr.setLowestAsk(scale(brv.getLowestAsk()));
                fvcr.setPercentChange(scale(brv.getPercentChange()));
                fvcr.setQuotevolume(scale(brv.getQuoteVolume()));
                fvcr.setCoinType(arr[i]);
                list.add(fvcr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    public static BigDecimal scale(double f) {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return BigDecimal.valueOf(f1);
    }

}
