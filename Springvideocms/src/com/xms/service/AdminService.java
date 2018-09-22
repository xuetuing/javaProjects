package com.xms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.bean.Page;
import com.xms.dao.AdminMapper;
import com.xms.entity.User;

@Service
public class AdminService {
	
	@Resource
	private AdminMapper amapper;
	@Resource
	private Page pages;

	public List<User> findByPage(int page) {
		int index = (page - 1) * pages.getPageSize();
		
		return amapper.findByPage(index,pages.getPageSize());
	}

	public int getTotalPages(int pageSize) {
		int records = amapper.getTotalRecords();
		return records%pageSize==0?records/pageSize:records/pageSize+1;
	}

	
	
	
}
