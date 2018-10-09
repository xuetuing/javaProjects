package com.xms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.bean.Page;
import com.xms.dao.UserMapper;
import com.xms.entity.User;

@Service
public class UserService {
	
	@Resource
	private UserMapper umapper;
	@Resource
	private Page pages;

	public List<User> findByPage(int page) throws Exception{
		//System.out.println(pages.getPageSize());
		int index = (page - 1) * pages.getPageSize();
		
		return umapper.findByPage(index,pages.getPageSize());
	}
	
	public int getTotalPages(int pageSize) throws Exception{
		int records = umapper.getTotalRecords();
		return records%pageSize==0?records/pageSize:records/pageSize+1;
	}
	
}
