package com.shsxt.util;

import com.google.gson.Gson;

/**
 * String的工具类
 * @author wawjy
 *
 */
public class StringUtil {
	/**
	 * 
	 * @param str
	 * @return  为空返回true    不空  false
	 */
	// 非空验证
	public static boolean isEmptyOrNull(String str) {
		if(null == str || "".equals(str)) {
			return true;
		}
		return false;
	}
	// 将字符串的首字母大写
		public static String firstCharUp(String str) {
			if(!StringUtil.isEmptyOrNull(str)) {
				str = str.substring(0,1).toUpperCase() + str.substring(1);
			}
			return str;
		}

		public static String getJsonString(Object obj){
			Gson gson= new Gson();
			String json= gson.toJson(obj);
			return json;
			
			
		}	

}
