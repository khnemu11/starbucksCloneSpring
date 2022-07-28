package com.spring.starbucks.daos;

import com.spring.starbucks.beans.LoginBean;
import com.spring.starbucks.beans.UserBean;


public interface LoginService {
	public UserBean login(LoginBean loginBean);
	public String register(UserBean user);
	public int idCheck(UserBean user);
}
