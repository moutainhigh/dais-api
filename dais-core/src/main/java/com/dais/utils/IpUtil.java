package com.dais.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author xxp
 * @version 2017- 09- 10 12:18
 * @description
 * @copyright www.zhgtrade.com
 */
public class IpUtil {

     public static String getIp(HttpServletRequest request) {
                 Enumeration<String> strs = request.getHeaderNames() ;
         while(strs.hasMoreElements()){
             System.out.println(strs.nextElement());
         }

         String ip = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
        //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
             }else{
               return ip;
            }
       }
       ip = request.getHeader("X-Real-IP");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
          return ip;
        }
     return request.getRemoteAddr();
  }
}
