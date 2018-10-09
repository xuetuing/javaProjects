package com.xms.dao;

import org.springframework.stereotype.Repository;

import com.xms.entity.User;
@Repository
public interface UserDao {
	public User findByName(String email) throws Exception;
}
