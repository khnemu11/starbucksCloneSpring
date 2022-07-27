package com.spring.starbucks.daos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.starbucks.beans.Coffee;

@Repository("coffeeDao")
public class CoffeeDao {
	
	@Resource(name="sqlSessoinTemplate")
	SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	public List<Coffee> selectCoffeeBeanByName(Coffee c){    
		List<Coffee> coffeeList= session.selectList("coffeeBean_mapper.selectByName", c.getName_kr());
		return coffeeList;
	}
	public Coffee selectCoffeeBeanBySeq(int seq){    
		Coffee coffee= session.selectOne("coffeeBean_mapper.selectBySeq", seq);
		return coffee;
	}    
	public List<Coffee> selectAllCoffeeBean(){    
		List<Coffee> coffeeList= session.selectList("coffeeBean_mapper.selectAll");
		return coffeeList;
	}  
	public int insertCoffeeBean(Coffee c){    
		return session.insert("coffeeBean_mapper.insertCoffeeBean",c);
	}  
	public int deleteCoffeeBean(int seq) {
		return session.delete("coffeeBean_mapper.deleteCoffeeBean",seq);
	}
	public int updateCoffeeBean(Coffee c) {
		return session.delete("coffeeBean_mapper.updateCoffeeBean",c);
	}
	public int selectDuplicatedNameWithoutSelf(Coffee c) {
		return session.selectOne("coffeeBean_mapper.selectDuplicatedNameWithoutSelf", c);
	}
	public List<Coffee> getAllRecords() {
		System.out.println("getAllRecords start");
		List<Coffee> list = new ArrayList<Coffee>();
		try {
			list = session.selectList("coffeeBean_mapper.selectAll");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("getAllRecords end");
		return list;
	}
}
