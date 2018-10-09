package com.xms.dao;

import java.util.List;

import com.xms.entity.Admin;
import com.xms.entity.User;

public interface AdminMapper {
	List<User> findByPage(int index, int pageSize);

	int getTotalRecords();

	Admin findByName(String username);
	
}
