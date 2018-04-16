package com.shsxt.util;

import com.shsxt.constant.LFConstant;

/**
 * @author Administrator
 *结果对象
 *	状态码
 *	消息
 *	结果对象
 */
public class ResultInfo<T> {
		private Integer code=LFConstant.SUCCESS;
		private String msg="";
		private T resultData;
		public ResultInfo() {
		}
		public ResultInfo(Integer code, String msg, T resultData) {
			
			this.code = code;
			this.msg = msg;
			this.resultData = resultData;
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public T getResultData() {
			return resultData;
		}
		public void setResultData(T resultData) {
			this.resultData = resultData;
		}	
		
		
		
}
