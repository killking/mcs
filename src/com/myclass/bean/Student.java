package com.myclass.bean;

public class Student {
	//学号
	private Integer sno;
	//学生的姓名
	private String name;
	//学生的生日
	private String birthday;
	//年龄
	private Integer age;
	//性别
	private String sex;
	//地址
	private String address;
	//电话
	private String phone;
	//学生的个人介绍
	private String introduce;
	
	public Student() {
	}
	
	public Student(Integer sno, String name, String birthday, Integer age, String sex, String address, String phone,
			String introduce) {
		this.sno = sno;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.introduce = introduce;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
