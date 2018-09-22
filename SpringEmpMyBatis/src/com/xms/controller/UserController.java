package com.xms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xms.entity.User;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;
import com.xms.service.UserService;

@Controller
@RequestMapping("/login")
public class UserController {
	@Resource
	private UserService us;
	
	@RequestMapping("toLogin.do")
	public String toLogin(){
		return "jsp/login";
	}
	
	@RequestMapping("login.do")
	public String login(String username,String password,
			HttpServletRequest request) throws Exception{
		User user = us.checkLogin(username, password);
		request.getSession().setAttribute("user", user);
		
		return "redirect:/main/list.do";
	}
	
	@ExceptionHandler
	public String executeException(HttpServletRequest request,Exception e) throws Exception{
		request.getSession().invalidate();
		if(e instanceof UsernameException){
			request.getSession().setAttribute("unameMsg", e.getMessage());
			return "redirect:toLogin.do";
		}else if(e instanceof PasswordException){
			request.getSession().setAttribute("upassMsg", e.getMessage());
			return "redirect:toLogin.do";
		}else{
			throw e;
		}
	}
}
