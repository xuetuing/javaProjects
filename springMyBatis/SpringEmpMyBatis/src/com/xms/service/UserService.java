package com.xms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.UserMapper;
import com.xms.entity.User;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;

@Service
public class UserService {
	@Resource
	private UserMapper umapper;

	
	public User checkLogin(String username,String password) throws Exception{
		User user = umapper.findByName(username);
		//System.out.println(user);
		if(user==null){
			throw new UsernameException("用户名错误");
		}else if(!user.getPassword().equals(password)){
			throw new PasswordException("密码错误");
		}else{
			return user;
		}
		
	}
	
	
}
