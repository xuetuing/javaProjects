package com.xms.dao;

import com.xms.entity.User;

public interface UserDao {
	public User findByName(String name) throws Exception;
	public void add_user(User user) throws Exception;
}
