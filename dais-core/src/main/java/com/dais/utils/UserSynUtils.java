package com.dais.utils;

import com.alibaba.fastjson.JSONObject;
import com.common.utils.HttpUtils;
import com.common.utils.SignatureUtil;
import com.dais.model.User;
import org.apache.log4j.Logger;

import java.util.TreeMap;


/**
 * @author xxp
 * @version 2017- 08- 09 20:08
 * @description
 * @copyright www.zhgtrade.com
 */
public class UserSynUtils {

    public static final Logger logger = Logger.getRootLogger();

    private static final String USERSYS_BASE = "http://120.27.24.200:8880";//用户系统的Url

    private static final String USERSYS_REGISTER_URL = "/api/register";//用户系统的注册链接

    private static final String USERSYS_LOGIN_URL = "/api/login";//用户系统的登录链接

    private static final String USERSYS_MODIFY_URL = "/api/editUserInfo";//用户系统的修改链接

    private static final String USERSYS_SYN_URL = "/api/getUserInfoInsideImp";//用户系统的同步链接

    private static final String USER_SYS_APP_ID = "9521475BBD804C6A98E35E7C63395ED7";//众股用户系统APPID

    private static final String USER_SYS_APP_SECRET = "aff30df6d443c4ec32ffeccc6d87db272427b97f";//众股用户系统密钥

    private static final boolean USER_SYSTEM_ENABLE = false;//是否开启用户系统同步


    public static String MOBILE_KEY = "mobile";
    public static String EMAIL_KEY = "email";
    public static String PASSWORD_KEY = "password";
    public static String OPEN_ID_KEY = "open_id";
    public static String REAL_NAME_KEY = "real_name";
    public static String USERNAME_KEY = "user_name";

    public static TreeMap<String, Object> getParamMap(){
        TreeMap map = new TreeMap();
        map.put("app_id", USER_SYS_APP_ID);
        map.put("app_secret", USER_SYS_APP_SECRET);
        return map;
    }

    public static TreeMap signParamMap(TreeMap map){
        map.put("sign", SignatureUtil.getSign(map));
        map.remove("app_secret");
        return map;
    }


    public static boolean modifyUserInfo(User user) {
        if(!USER_SYSTEM_ENABLE) return false;
        TreeMap map = getParamMap();
        map.put(USERNAME_KEY, user.getFloginName());
        map.put(PASSWORD_KEY, user.getFloginPassword());
        try {
            JSONObject jsonResponse = HttpUtils.sendPostRequestForJson(USERSYS_BASE+USERSYS_MODIFY_URL, signParamMap(map));
            if (!"1".equals(jsonResponse.getString("ret"))) {
                logger.error("同步用户信息失败，响应内容：" + jsonResponse);
            }
        } catch (Exception e) {
            logger.error("同步用户信息失败", e);
        }
        return true;
    }

    public static String registerUserInfo(String username,String password) {
        if(!USER_SYSTEM_ENABLE) return "-2";
        String openId = null;
        TreeMap map = getParamMap();
        map.put(USERNAME_KEY, username);
        map.put(PASSWORD_KEY, password);
        try {
            JSONObject jsonResponse = HttpUtils.sendPostRequestForJson(USERSYS_BASE+USERSYS_REGISTER_URL, signParamMap(map));
            if (!"1".equals(jsonResponse.getString("ret"))) {
                logger.error("注册用户信息失败，响应内容：" + jsonResponse);
            } else {
                openId = jsonResponse.getString("data");
            }
        } catch (Exception e) {
            logger.error("注册用户信息失败", e);
        }
        System.out.println(openId);
        return openId;
    }

    public static String synUserInfo(String openid) {
        if(!USER_SYSTEM_ENABLE) return null;
        try {
            TreeMap map = getParamMap();
            map.put(OPEN_ID_KEY, openid);
            JSONObject jsonResponse = HttpUtils.sendPostRequestForJson(USERSYS_BASE+USERSYS_SYN_URL, signParamMap(map));
            if (!"1".equals(jsonResponse.getString("ret"))) {
                logger.error("同步用户信息失败，响应内容：" + jsonResponse);
            } else {
                JSONObject data = jsonResponse.getJSONObject("data");
                String password = data.getString(PASSWORD_KEY);
                return password;

                /*if (StringUtils.isMobile(mobile)) {
                    User.setFisTelephoneBind(true);
                    User.setFisTelValidate(true);
                    User.setFtelephone(mobile);
                }
                if (StringUtils.isEmail(email)) {
                    User.setFemail(email);
                    User.setFisMailValidate(true);
                }
                if(!User.getFhasRealValidate()){
                    if (StringUtils.hasText(realName)) {
                        User.setFrealName(realName);
                    }
                    if (StringUtils.hasText(cardId)) {
                        User.setFidentityNo(cardId);
                    }
                    if (StringUtils.hasText(cardType)) {
                        User.setFidentityType(Integer.valueOf(cardType));
                    }
                    if(StringUtils.hasText(User.getFidentityNo()) && StringUtils.hasText(User.getFrealName())){
                        User.setFpostRealValidate(true);
                        User.setFpostRealValidateTime(Utils.getTimestamp());
                    }
                }*/
            }
        } catch (Exception e) {
            logger.error("同步用户信息失败", e);
            e.printStackTrace();
        }

        return null;
    }

    // 用户登录(本地不存在该用户 则同步过来)
    public static Object synUserLogin(String loginName, String password){
        if(!USER_SYSTEM_ENABLE) return "-2";

        TreeMap map = getParamMap();
        map.put(USERNAME_KEY, loginName);
        map.put(PASSWORD_KEY, password);

        try{
            JSONObject jsonResponse = HttpUtils.sendPostRequestForJson(USERSYS_BASE+USERSYS_LOGIN_URL, signParamMap(map));
            if ("1".equals(jsonResponse.getString("ret"))) {
                // 登录成功
                JSONObject data = jsonResponse.getJSONObject("data");

                // mobile,email,real_name,sex,identify_type,identify_no,open_id
                String openId = data.getString(OPEN_ID_KEY);
                String mobile = data.getString(MOBILE_KEY);
                String email = data.getString(EMAIL_KEY);
                String realName = data.getString(REAL_NAME_KEY);
                String cardId = data.getString("identifyNo");
                String cardType = data.getString("identifyType");

                User user = new User();
                // 注册到本地
                user.setFloginName(loginName);
                user.setFnickName(loginName);
                if (StringUtils.isEmpty(email)) {
                    user.setFemail(email);
                    user.setFisMailValidate(true);
                }
                if (StringUtils.isEmpty(mobile)) {
                    user.setFtelePhone(mobile);
                    user.setFisTelephoneBind(true);
                }
                user.setFregisterTime(Utils.getTimestamp());
                user.setFloginPassword(Utils.MD5(password));
                if(StringUtils.hasText(realName)){
                    user.setFrealName(realName);
                }
                if(StringUtils.hasText(cardId)){
                    user.setFidentityNo(cardId);
                }
                if(StringUtils.hasText(cardType)){
                    user.setFidentityType(Integer.valueOf(cardType));
                }
                if(StringUtils.hasText(realName) && StringUtils.hasText(cardId)){
                    user.setFpostRealValidate(true);
                    user.setFhasRealValidateTime(Utils.getTimestamp());
                }
                return user;
            }else if("0".equals(jsonResponse.getString("ret"))){
                // 用户名或密码错误
                return "-1";
            }else{
                logger.error("众股用户系统登录出错，响应内容：" + jsonResponse);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("众股用户系统登录出错", e);
        }

        return "-2";
    }

    public static void main(String[] args) {
        User user = new User();
//        user.setFloginName("testxxp");
//        user.setFloginPassword("123123");
//        registerUserInfo(user);
        synUserLogin("xxly68","wym520");
//        user.setFzhgOpenId("DDEB82D831BD41DBA06FB9B8652E6E00");
//        synUserInfo(user);
    }
}
