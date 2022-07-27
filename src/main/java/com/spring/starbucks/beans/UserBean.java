package com.spring.starbucks.beans;

import org.springframework.web.multipart.MultipartFile;

public class UserBean extends LoginBean{
	private int year;
	private int month;
	private int day;
	private String name;

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
	
	@Override
	public String toString() {
		return "id : "+getId()+" password : "+getPassword()+" name : "+getName();
		
	}
}