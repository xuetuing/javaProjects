package com.xms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.AdminMapper;
import com.xms.entity.Emp;

@Service
public class EmpService {

	@Resource
	private AdminMapper emapper;
	
	public List<Emp> findAllEmp(){
		return emapper.findAll();
	}
	
	public void delete(int id){
		
		emapper.delete(id);
	}
}
