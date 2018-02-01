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
        btcMessage.setACCESS_KEY("u");
        btcMessage.setSECRET_KEY("p");
        btcMessage.setPASSWORD("123123");
        System.out.println(new Date());
        BTCUtils btcUtils = new BTCUtils(btcMessage);
//       BTCInfo btcInfo =  btcUtils.gettransactionValue("0xc2f2d905a066b1a5aba74288fae8d0d40e4cb3c6b0dae104fc6824d99a8d4ed8-0x2a03824e7542d9bec007bbac4d5d47290fd02811","receive");
        try {
//            JSONObject json = btcUtils.getInfo();
//            JSONObject jsonObject = btcUtils.settxfee(0.1/226 *1024);//每kb交易费
//            if(!jsonObject.containsKey("result") || StringUtils.isEmpty(jsonObject.get("result").toString())
//                    || !"true".equals(jsonObject.get("result").toString())){
//                System.out.println("************************");
//            }
            String json  = btcUtils.sendfromValue(btcUtils.getaccountValue("BqAJ2h47MQVUfMG9hU23BEUqWTN7Qe9Uun"),"BUdm6FSe11ZdorKpd8cXNV1awBrmEAAUW2",2,"aaa");
//            String json =  btcUtils.sendtoaddressValue("BUdm6FSe11ZdorKpd8cXNV1awBrmEAAUW2",2,"aaa");
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
