package com.xms.dao;

import org.springframework.stereotype.Repository;
import com.xms.entity.User;

@Repository
public interface UserMapper {
	
	//根据用户名查找
	public User findByName(String username);
	
	
}






