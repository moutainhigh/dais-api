package com.common.utils;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GanZhen
 * @version 2017- 07- 05 15:28
 * @description
 * @copyright www.zhgtrade.com
 */
public class SmsUtils {

    public static final String MESSAGE_NAME = "messageName";
    public static final String MESSAGE_PASSWORD = "messagePassword";

    public static final Logger logger = Logger.getLogger(SmsUtils.class);

    public static boolean sendMessage(Map<String, String> account, Object phone, Object content) {
        try {
            if (phone == null || content == null) {
                return false;
            }
            logger.debug("发送短信到" + phone);
            return send(account.get(MESSAGE_NAME), account.get(MESSAGE_PASSWORD), phone.toString(), content.toString());
        } catch (Exception e) {
            logger.error("发送短信失败"+ e);
        }
        return false;
    }

    private static boolean send(String name, String password, String phone, String content){
        boolean flag = false ;
        try {
            Map<String, String> map = new HashMap<>();
            map.put("un", name.trim());
            map.put("pw", password.trim());
            map.put("phone", phone.trim());
            map.put("msg", content.trim());
            map.put("rd", "1");
            String result = HttpClientUtils.post("http://sms.253.com/msg/send", map, "utf-8");

            if(StringUtils.hasText(result) && 2 == result.split("\\n").length) {
                flag = true;
                logger.info("发送短信返回信息为："+ result);
            } else {
                logger.error("发送短信返回信息为："+ result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
