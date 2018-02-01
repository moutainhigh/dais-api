package com.common.pojo;

/**
 * @author GanZhen
 * @version 2017- 05- 11 11:05
 * @description 数据库通用参数的主键值，使用主键查询的效率比使用
 *                  varchar类型的key速度快很多
 * @copyright www.zhgtrade.com
 */
public class CommonParamsId {

    /**
     * 非法头像的图片主键id
     */
    public static final Long ILLEGALITY_HEADER = 1L;

    public static final Long USERSYS_BASE = 2L;

    public static final Long USERSYS_APP_ID = 3L;

    public static final Long USERSYS_APP_SECRET = 4L;

    public static final Long USERSYS_REGISTER_URL = 5L;

    public static final Long USERSYS_LOGIN_URL = 6L;

    public static final Long USERSYS_SYN_URL = 7L;

    public static final Long BASE_TRADE_URL = 8L;

    public static final Long TRADE_OUTBTCADDRESS_URL = 9L;

    public static final Long TRADE_ADDRESS_URL = 10L;

    public static final Long TRADE_REST_MONEY_URL = 11L;

    public static final Long TRADE_MODIFYWITHDRAWBTCADDR_URL = 12L;

    public static final Long TRADE_COINOPERATE_URL = 13L;

    public static final Long TRADE_WITHDRAWBTC_URL = 14L;

    public static final Long TRADE_SMS_URL = 15L;

    public static final Long TRADE_EXCHANGE_URL = 16L;

    public static final Long PLATFORM_RATE = 17L;

    public static final Long EXPRESS_QUERY_INTERVAL_ID = 18L;

    public static final Long MONEY_TO_POINT_RATE_ID = 19L;

    public static final Long TRADE_USER_LOGIN_URL = 20L;

    public static final Long USER_SYSTEM_ENABLE = 21L;

    public static final Long USER_SYS_IPS = 22L;

    public static final Long TRANSFER_SECRET = 23L;

    public static final Long USER_TRANSFER_SYSTEM_TAG = 24L;

    public static final Long USER_TRANSFER_COIN_ENABLE_URL = 25L;

    public static final Long USER_TRANSFER_URL = 26L;

    public static final Long CHANGE_ACCOUNT = 27L;

    public static final Long MINWITHDRAW = 28L;

    public static final Long MAXWITHDRAW = 29L;

    public static final Long DAY_DRAW_COIN_TIMES = 30L;

    public static final Long MESSAGE_NAME = 31L;

    public static final Long MESSAGE_PASSWORD = 32L;

    public static final Long EXPRESS_FEE = 33L;

    public static final Long DEFAULT_EXPRESS = 34L;
}
