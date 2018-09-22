package com.xms.service;

import java.awt.image.BufferedImage;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.AdminMapper;
import com.xms.entity.Admin;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;
import com.xms.util.ImgUtil;

@Service
public class LoginService {
	@Resource
	private AdminMapper adminMapper;
	
	public Admin checkLogin(String username,String password) throws Exception{
		Admin admin = adminMapper.findByName(username);
		if(admin==null){
			throw new UsernameException("用户名错误");
		}else if(!admin.getPassword().equals(password)){
			throw new PasswordException("密码错误");
		}else{
			return admin;
		}
	}
	
	public Map<String,BufferedImage> getImage(){
		return ImgUtil.getImage();
	}
	
	
}
