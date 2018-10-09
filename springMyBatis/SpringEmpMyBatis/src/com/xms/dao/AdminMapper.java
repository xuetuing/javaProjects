package com.xms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.xms.entity.Emp;

@Repository
public interface AdminMapper {
	
	public List<Emp> findAll();
	
	public Emp findById(int id);
	
	public void delete(int id);
}
