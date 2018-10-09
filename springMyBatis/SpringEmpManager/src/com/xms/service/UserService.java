package com.xms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.EmpDAO;
import com.xms.dao.UserDao;
import com.xms.entity.Emp;
import com.xms.entity.User;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;


@Service
public class UserService {
	@Resource
	private UserDao udao;
	@Resource
	private EmpDAO edao;
	
	public User checkLogin(String username,String password) throws Exception{
		User user = udao.findByName(username);
		if(user==null){
			throw new UsernameException("用户名错误");
		}else if(!user.getPassword().equals(password)){
			throw new PasswordException("密码错误");
		}else{
			return user;
		}
	}
	
	public List<Emp> getEmpList() throws Exception{
		return edao.findAll();
		
	}
	
}
