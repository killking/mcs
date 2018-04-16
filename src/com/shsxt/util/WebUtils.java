package com.shsxt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class WebUtils {
	
	// 将字符串的首字母大写
	public static String firstCharUp(String str) {
		if(!WebUtils.isNullOrBlank(str)) {
			str = str.substring(0,1).toUpperCase() + str.substring(1);
		}
		return str;
	}
	/**
	 * 处理空
	 */
	public static boolean isNullOrBlank(String val){
		return null==val?true:val.trim().equals("");
	}
		

}
