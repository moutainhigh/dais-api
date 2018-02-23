import com.common.model.BTCInfo;
import com.common.model.BTCMessage;
import com.common.utils.BTCUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author GanZhen
 * @version 2017- 08- 19 9:46
 * @description
 * @copyright www.zhgtrade.com
 */
public class BtcTest {

    public static void main(String[] args) throws Exception {
        BTCMessage btcMessage = new BTCMessage();
        btcMessage.setIP("127.0.0.1");

//        btcMessage.setPORT("6969");
        btcMessage.setPORT("9596");
        btcMessage.setACCESS_KEY("bthuser");
        btcMessage.setSECRET_KEY("bthpassword");
        btcMessage.setPASSWORD("111111");
        System.out.println(new Date());
        BTCUtils btcUtils = new BTCUtils(btcMessage);
       BTCInfo btcInfo =  btcUtils.gettransactionValue("70a51b1449f334649f5cfad5f949555b8a742e14f0e27312cb00513f956b8b35","send");
        try {
//            JSONObject json = btcUtils.getInfo();
//            JSONObject jsonObject = btcUtils.settxfee(0.1/226 *1024);//每kb交易费
//            if(!jsonObject.containsKey("result") || StringUtils.isEmpty(jsonObject.get("result").toString())
//                    || !"true".equals(jsonObject.get("result").toString())){
//                System.out.println("************************");
//            }
//            String json  = btcUtils.sendfromValue(btcUtils.getaccountValue("BqAJ2h47MQVUfMG9hU23BEUqWTN7Qe9Uun"),"BUdm6FSe11ZdorKpd8cXNV1awBrmEAAUW2",2,"aaa");
//            String json =  btcUtils.sendtoaddressValue("BUdm6FSe11ZdorKpd8cXNV1awBrmEAAUW2",2,"aaa");
//            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
