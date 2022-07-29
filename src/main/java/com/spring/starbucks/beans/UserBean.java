package com.spring.starbucks.beans;

import org.springframework.web.multipart.MultipartFile;

public class UserBean extends LoginBean{
	private int year;
	private int month;
	private int day;
	private String name;
	private String sex;
	private String phone;
	private String nickname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "id : "+getId()+" password : "+getPassword()+" name : "+getName() + " year : "+getYear() + " month " + getMonth() + 
				" day : "+ getDay() + " sex : "+ getSex()  + " phone : " + getPhone() + " nickname : " + getNickname();
		
	}
}