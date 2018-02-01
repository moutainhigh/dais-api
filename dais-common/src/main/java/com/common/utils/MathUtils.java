package com.common.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 招股金服
 * Double类型计算
 * 精度精确到小数点后6位
 * 超过6位则进行四舍五入
 * CopyRight : www.zhgtrade.com
 * Author : 林超（362228416@qq.com）
 * Date： 2016-04-24 20:03
 */
public class MathUtils {

    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double subtract(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1 + "");
        BigDecimal b2 = new BigDecimal(value2 + "");
        return b1.subtract(b2).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double multiply(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1 + "");
        BigDecimal b2 = new BigDecimal(value2 + "");
        return b1.multiply(b2).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String multiply2(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1 + "");
        BigDecimal b2 = new BigDecimal(value2 + "");
        return subZeroAndDot(b1.multiply(b2).setScale(6, BigDecimal.ROUND_HALF_UP).toString());
    }

    /**
     * 提供精确的除法运算方法div
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double divide(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1 + "");
        BigDecimal b2 = new BigDecimal(value2 + "");
        return b1.divide(b2,8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public static double convert(double value, int scale){
    	return new BigDecimal(value + "").setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String convert2(double value, int scale){
        return subZeroAndDot(new BigDecimal(value + "").setScale(scale, BigDecimal.ROUND_HALF_UP).toString());
    }

    /**
     * 去掉小数点后面的0
     * @param value
     * @return
     */
    public static String format(double value){
        NumberFormat nf = NumberFormat.getInstance();
       return nf.format(value);
    }
    
    public static void main(String[] args) {
//        new BigDecimal(0.0002 + "").setScale(6, BigDecimal.ROUND_HALF_UP).toString();
		String a = new BigDecimal(0.0002 + "").setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        System.out.println(subZeroAndDot(a));
//        NumberFormat nf = NumberFormat.getInstance();
//        nf.format(3.300);
    }
    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

}