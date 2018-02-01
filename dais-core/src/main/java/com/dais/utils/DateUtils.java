package com.dais.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author xuelin
 * @date   2016年4月18日
 * @desc
 */
public abstract class DateUtils {
	/**
	 * 获取日期几分钟前，几年前
	 * 方法名：getTimeFormat<BR>
	 * 创建人：yujie <BR>
	 * 时间：2014年11月11日-下午10:27:54 <BR>
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getTimeFormat(Date startTime){
		try{
			if(startTime==null){return null;}
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}

	public final static String DEFAULT_FORMAT = "yyyy-MM-dd";

	/**
	 * 格式化日期  yujie 2016/06/22
	 * @param date
	 * @param format
     * @return
     */
	public static String formatDate(Date date, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}


	public static String formatDateChat(Date date){
		String format;
		Date date1 = Utils.getTimestamp();
		if(getDays(date,date1) < 1){
			format = "HH:mm";
		}else if(getMounth(date,date1) < 1){
			format = "MM-dd HH:mm";
		}else if(getYears(date,date1) < 1){
			format = "MM-dd HH:mm";
		}else{
			format = "yyyy-MM-dd HH:mm";
		}
		return formatDate(date, format);
	}

	public static String formatDate(Date date){
		return formatDate(date, DEFAULT_FORMAT);
	}
	
	public static Date formatDate(String dateStr, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date formatDate(String dateStr){
		return formatDate(dateStr, DEFAULT_FORMAT);
	}
	
	/**
	 * 计算相差天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDays(Date start, Date end){
		return (int) (((end.getTime() - start.getTime()) / (24*60*60*1000l)));
	}
	public static int getMounth(Date start, Date end){
		return (int) (((end.getTime() - start.getTime()) / (30*24*60*60*1000l)));
	}
	public static int getYears(Date start, Date end){
		return (int) (((end.getTime() - start.getTime()) / (12*30*24*60*60*1000l)));
	}

	public static int getHours(Date start, Date end){
		return (int) (((end.getTime() - start.getTime()) / (60*60*1000)));
	}

	public static int getMinute(Date start, Date end){
		if(start == null || end == null){
			return 0;
		}
		return (int) (((end.getTime() - start.getTime()) / (60*1000)));
	}


	/**
	 * 当天开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 当天结束时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getDateLastTime(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 一个月前
	 * @return
	 */
	public static Date getMonthBefore(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 15天前
	 * @return
	 */
	public static Date getHalfMonthBefore(){
		return getDaysBefore(15);
	}
	
	/**
	 * 几天前
	 * @param days
	 * @return
	 */
	public static Date getDaysBefore(int days){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 几小时后
	 * @param hours
	 * @return
     */
	public static Date getHoursAfter(Date date, int hours){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	/**
	 * 几秒后
	 *
	 * @param date
	 * @param seconds
     * @return
     */
	public static Date getSecondAfter(Date date, int seconds){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}


	/**
	 * 格式化时间
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {

		Calendar current = Calendar.getInstance();

		Calendar today = Calendar.getInstance();	//今天

		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set( Calendar.HOUR_OF_DAY, 0);
		today.set( Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);

		Calendar lastyear = Calendar.getInstance();
		lastyear.set(Calendar.YEAR, current.get(Calendar.YEAR)-1);
		lastyear.set(Calendar.MONTH, current.get(Calendar.MONTH));
		lastyear.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		lastyear.set( Calendar.HOUR_OF_DAY, 0);
		lastyear.set( Calendar.MINUTE, 0);
		lastyear.set(Calendar.SECOND, 0);

		current.setTime(date);
		String format = "HH:mm";
		if(current.after(today)){
			format = "HH:mm";
		}else if(current.after(lastyear)){
			format = "MM-dd HH:mm";
		}else{
			format = "yyyy-MM-dd HH:mm";
		}
		return formatDate(date, format);
	}

}









