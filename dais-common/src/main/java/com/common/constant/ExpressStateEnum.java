package com.common.constant;

/**
 * @author GanZhen
 * @version 2017- 05- 17 15:38
 * @description
 * @copyright www.zhgtrade.com
 */
public enum ExpressStateEnum {
    /**
     * 在途中
     */
    ON_THE_WAY(2),
    /**
     * 签收
     */
     RECEIVED(3),
    /**
     * 问题件
     */
     PROBLEM_ITEM(4);

     private int state;

    ExpressStateEnum(int state){
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
