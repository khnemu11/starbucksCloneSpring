package com.spring.starbucks.daos;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.starbucks.beans.LoginBean;
import com.spring.starbucks.beans.UserBean;

@Repository("loginDao")
public class LoginDao {
	
	@Resource(name="sqlSessoinTemplate")
	SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insertUserBean(UserBean u){    
		return session.insert("loginBean_mapper.insertUser",u);
	}  
	public UserBean selectLogin(LoginBean l) {
		return session.selectOne("loginBean_mapper.selectLogin", l);
	}
	public int selectUserId(UserBean l) {
		return session.selectOne("loginBean_mapper.selectUserId", l);
	}
}
