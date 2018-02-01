package com.common.utils;


import com.common.oss.AliyunService;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class Utils {

	private static final char EXTENSION_SEPARATOR = '.';

	private static final String FOLDER_SEPARATOR = "/";

	public static boolean isAjax(HttpServletRequest request){
		String header = request.getHeader("X-Requested-With"); 
	    return header != null && "XMLHttpRequest".equals(header);
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ipFromNginx = getHeader(request, "X-Real-IP");
		if (!StringUtils.isEmpty(ipFromNginx)) {
			return ipFromNginx;
		}
		return request.getRemoteAddr();
	}

	private static String getHeader(HttpServletRequest request, String headName) {
		String value = request.getHeader(headName);
		return !StringUtils.isEmpty(value) && !"unknown".equalsIgnoreCase(value) ? value : "";
	}

	public static String MD5(String content) {
//		MessageDigest md5 = MessageDigest.getInstance("MD5");
//		sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
//		String retString = baseEncoder.encode(md5.digest(content.getBytes()));
		return getMD5_32(content);
	}

	public static String getMD5_32(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	public final static boolean isNumeric(String s) {
		if (s != null && !"".equals(s.trim()))
			return s.matches("^[0-9]*$");
		else
			return false;
	}

	public static boolean uploadFileToOss(InputStream is, String filePath){
		AliyunService aliyunService = SpringContextUtils.getBean(AliyunService.class);
		try {
			aliyunService.updateFile(is, filePath, getFileExt(filePath));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteFileToOss(InputStream is, String filePath){
		AliyunService aliyunService = SpringContextUtils.getBean(AliyunService.class);
		try {
//			aliyunService.deleteFile();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 不带电文件后缀名
	 * 招股金服
	 * CopyRight : www.zhgtrade.com
	 * Author : 俞杰（945351749@qq.com）
	 * Date : 2016年4月8日 上午11:55:18
	 */
	public static String getFileExt(String fileName) {
		if (fileName.lastIndexOf(".") == -1)
			return "";
		int pos = fileName.lastIndexOf(".") + 1;
		return fileName.substring(pos, fileName.length());
	}

	public static String getFilenameExtension(String path) {
		if (path == null) {
			return null;
		}
		int extIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
		if (extIndex == -1) {
			return null;
		}
		int folderIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		if (folderIndex > extIndex) {
			return null;
		}
		return path.substring(extIndex + 1);
	}

	public static String getRelativeFilePath(String fileExt, byte[] bytes){
		return getRelativeFilePath(fileExt, bytes, null);
	}

	public static String getRelativeFilePath(String fileExt, byte[] bytes, Object extFileName){
		StringBuilder filePath = new StringBuilder();

		filePath.append("/").append(DateUtils.formatDate(new Date(), "yyyyMM")).append("/");
		if(bytes.length > 40){
			byte[] copyArr = new byte[10];
			System.arraycopy(bytes, 30, copyArr, 0, 10);
			String hexStr = bytesToHexString(copyArr);
			filePath.append(hexStr).append(randomString(5));
		}else{
			filePath.append(getRandomImageName());
		}
		if(null != extFileName){
			// 标识参数
			filePath.append("_").append(extFileName);
		}
		filePath.append(".").append(fileExt);
		return filePath.toString();
	}

	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	public static Long getTimeLong(){
		return new Date().getTime();
	}

	// 获得随机字符串
	public static String randomString(int count) {
		String str = "abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
		int size = str.length();
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		while (count > 0) {
			sb.append(String.valueOf(str.charAt(random.nextInt(size))));
			count--;
		}
		return sb.toString();
	}

	public static String getRandomImageName() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmsss");
		String path = simpleDateFormat.format(new Date());
		path += "_" + randomString(5);
		return path;
	}

	// 获得今天0点
	public static long getTimesmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	public static boolean isImage(byte[] bytes){
		if(0 == bytes.length){
			return false;
		}

		byte[] copyArr = new byte[28];
		System.arraycopy(bytes, 0, copyArr, 0, 28);
		String hexStr = bytesToHexString(copyArr).toUpperCase();

		// jpeg|png|gif
		return hexStr.startsWith("FFD8FF") || hexStr.startsWith("89504E47") || hexStr.startsWith("47494638");
	}
}
