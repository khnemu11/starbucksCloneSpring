package com.spring.starbucks.daos;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spring.starbucks.beans.LoginBean;
import com.spring.starbucks.beans.UserBean;

@Service
public class LoginServiceImpl implements LoginService{
	@Resource(name="loginDao")
	LoginDao dao;
	
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@Override
	public UserBean login(LoginBean loginBean) {
		return dao.selectLogin(loginBean);
	}

	@Override
	public String register(UserBean user) {
		int duplicate = dao.selectUserId(user);
		
		if(duplicate >0) {
			System.out.println("duplicate id");
			return "Duplciated ID";
		}
		
		int result = dao.insertUserBean(user);
		System.out.println("result : "+result);
		if(result == 1) {
			System.out.println("register success");
			return "success";
		}
		else {
			System.out.println("resgister fail");
			return "Register Fail";
		}
	}

	@Override
	public int idCheck(UserBean user) {
		return dao.selectUserId(user);
	}
}
