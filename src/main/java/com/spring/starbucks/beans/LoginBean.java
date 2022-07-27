package com.spring.starbucks.beans;

import org.springframework.web.multipart.MultipartFile;

public class LoginBean{
	private Long seq;
	private String id;
	private String password;
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "id : "+getId()+" password : "+getPassword();
		
	}
}