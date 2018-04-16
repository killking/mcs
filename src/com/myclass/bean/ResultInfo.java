package com.myclass.bean;
/**
 * 处理结果
 * 1、结果编号
 * 2、结果描述
 * 3、对象信息
 * @author Administrator
 *
 */
public class ResultInfo<T> {
	//编号  -1 错误   1 成功  
	private int code;  // 0
	//描述
	private String msg;
	//对象
	private T result;
	
	public ResultInfo() {
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	
}
