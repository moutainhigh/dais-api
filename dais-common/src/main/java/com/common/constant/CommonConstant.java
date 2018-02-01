package com.common.constant;

/**
 * @author GanZhen
 * @version 2017- 04- 20 15:07
 * @description
 * @copyright www.zhgtrade.com
 */
public class CommonConstant {

    public static final String PHONE_REGEX = "^1[0-9]{10}$";

    public static final String IDENTITYCARD_REGEX  = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";

    public static final String LONGITUDE_REGEX  = "^-?(([1-9]\\d?)|(1[1-7]\\d)|180)(\\.\\d{1,6})?$";

    public static final String LATITUDE_REGEX  = "^-?(([1-8]\\d?)|([1-8]\\d)|90)(\\.\\d{1,6})?$";

    public static final String PAY_TYPE_SHOPPING = "shopping";

    public static final String PAY_TYPE_RECHARGE = "recharge";

    public static final String PAY_TYPE_MEMBER_UPDATE = "member_update";

    public static final String POINTS_PLATFORM_RETURN = "平台返还";

    public static final int POINTS_PLATFORM_RETURN_ID = 4;

    public static final String POINTS_CHECK_IN = "签到";

    public static final String POINTS_MEMBER_LEVEL = "升级会员";

    public static final String POINTS_HEADER_UPLOAD = "上传头像";

    // 跳转url
    public static final String FORWARD_URL = "forward_url";

    /**
     * 当前用户
     */
    public static final String USER_LOGIN_SESSION = "login_user";

    /**
     * 当前用户的详细信息
     */
    public static final String MEMBER_LOGIN_SESSION = "member_info";

    /**
     * 角色key
     */
    public static final String ROLE_KEY = "role_key";

    public static final String SESSION_NEW_CAPTCHA_CODE = "new_captcha";


}
