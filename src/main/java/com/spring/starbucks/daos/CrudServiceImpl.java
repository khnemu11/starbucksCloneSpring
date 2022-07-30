package com.spring.starbucks.daos;
import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.starbucks.beans.Coffee;

@Service
public class CrudServiceImpl implements CrudService{
	@Resource(name="coffeeDao")
	CoffeeDao dao;
	
	public void setDao(CoffeeDao dao) {
		this.dao = dao;
	}

	@Override
	public int save(Coffee c,String directory) {
		System.out.println("insert "+c.getName_kr()+" start");
		int status = 0;
		try {
			List<Coffee> coffeeList= dao.selectCoffeeBeanByName(c);
			if(coffeeList.size()>0) {
				System.out.println(c.getName_kr()+" is already exists");
				return status;
			}
			System.out.println("weight : "+c.getWeight());
			System.out.println("processign mode  : "+c.getProcessing_method());
			dao.insertCoffeeBean(c);
			System.out.println("insert "+c.getName_kr()+" finish");
			
			List<Coffee> savedCoffee = dao.selectCoffeeBeanByName(c);
			Long savedCoffeeSeq = savedCoffee.get(0).getSeq();
			
			System.out.println("seq : "+savedCoffeeSeq);
			
			String fileName = "coffee_bean_"+savedCoffeeSeq+".jpg";
			File file = new File(directory+"/coffee_bean_"+savedCoffeeSeq+".jpg");
			
			System.out.println(file.getAbsolutePath());
			if(file.exists()) {
				System.out.println("file is alreay exists");
				file.delete();
			}	
			
			c.getFile().transferTo(new File(directory,fileName));
			System.out.println("file is uploaded");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
	}
	  @Override 
	  public int edit(Coffee c,String directory) {
		  System.out.println("edit "+c.getName_kr()+" start");
			int status = 0;
			try {
				int duplicated= dao.selectDuplicatedNameWithoutSelf(c);
				if(duplicated>0) {
					System.out.println(c.getName_kr()+" is already exists");
					return status;
				}
				System.out.println("no duplicate");
				
				dao.updateCoffeeBean(c);
				System.out.println("update "+c.getName_kr()+" finish");
				if(!c.getFile().getOriginalFilename().equals("")) {
					Long savedCoffeeSeq = c.getSeq();
					
					System.out.println("seq : "+savedCoffeeSeq);
				
					String fileName = "coffee_bean_"+savedCoffeeSeq+".jpg";
					File file = new File(directory+"/coffee_bean_"+savedCoffeeSeq+".jpg");
					
					System.out.println(file.getAbsolutePath());
					if(file.exists()) {
						System.out.println("file is alreay exists");
						file.delete();
					}	
					
					c.getFile().transferTo(new File(directory,fileName));
					System.out.println("file is uploaded");
				}
				else {
					System.out.println("no file change");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return status;
	  }
	 
	  @Override
	  public int delete(int id) {
		  return dao.deleteCoffeeBean(id);
	  }
	  
	  
	 
	@Override
	public List<Coffee> getAllRecords(){
		return dao.selectAllCoffeeBean();
	}

	@Override
	public Coffee getRecordBySeq(int id) {
		return dao.selectCoffeeBeanBySeq(id);
	}
}
