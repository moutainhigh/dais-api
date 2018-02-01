package com.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class SignatureUtil {


    public static String getSign(Map<String, String> map) {
        String msg = "";
        try {
            for (String value : map.keySet())
                msg += value + "=" + URLEncoder.encode(map.get(value), "UTF-8") + "&";

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        msg = msg.substring(0, msg.lastIndexOf("&"));
        return HashUtil.SHA1(msg);
    }

    public static String getSign(String msg) {
        return HashUtil.SHA1(msg);
    }

    public static void main(String[] str){
        Map<String,String> map=new TreeMap<String,String>();
        map.put("user_name","testusername");
        map.put("password","123456");
        map.put("app_id","2B112419BE0A4D58BC1087A07B60F803");
        map.put("app_secret","fc92ec9dbb339c8f08a4e8864c7ce2b5ef01ce7c");

        System.out.println(getSign(map));
    }
}
