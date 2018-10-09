package com.xms.dao;

import java.util.List;

import com.xms.entity.User;

public interface UserMapper {
	List<User> findByPage(int index,int pageSize);
	
	int getTotalRecords();
}
