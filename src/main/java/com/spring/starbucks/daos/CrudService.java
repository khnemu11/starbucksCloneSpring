package com.spring.starbucks.daos;
import java.util.List;

import com.spring.starbucks.beans.Coffee;


public interface CrudService {
	public int save(Coffee coffee,String directory);
	public int edit(Coffee coffee,String directory);
	public int delete(int id);
	public Coffee getRecordBySeq(int id);   
	List<Coffee> getAllRecords();
}
