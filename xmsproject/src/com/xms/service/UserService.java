package com.xms.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xms.dao.UserDao;
import com.xms.entity.User;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;

@Service
public class UserService {
	@Resource
	private UserDao dao;
	public User checkLogin(String email,String password) throws Exception{
		User user = dao.findByName(email);
		if(user==null){
			//用户名错误
			 throw new UsernameException("用户名错误");
		}else if(!user.getPassword().equals(password)){
			//密码错误
			throw new PasswordException("密码错误");
		}else{
			return user;
		}
	}
	
	
}
