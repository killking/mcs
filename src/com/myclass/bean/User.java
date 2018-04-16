package com.myclass.bean;

public class User {
	//用户的登录id
	private Integer uid;
	//用户的密码
	private String pwd;
	//用户的类型 1代表老师 2代表学生
	private Integer utype;
	private String sno;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getUtype() {
		return utype;
	}
	public void setUtype(Integer utype) {
		this.utype = utype;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String pwd, String sno) {
		super();
		this.pwd = pwd;
		this.sno = sno;
	}
	public User(Integer uid, String pwd, Integer utype, String sno) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.utype = utype;
		this.sno = sno;
	}
	
	
	
}
