package com.xms.Controller;


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
public class XmsController {
	@Resource
	private UserService us;
	
	@RequestMapping("toLogin.do")
	public String toLogin(HttpServletRequest request){
		return "login";
	}
	
	@RequestMapping("login.do")
	public String login(String email,String password,
			HttpServletRequest request) throws Exception{
		request.getSession().invalidate();
		System.out.println(email);
//		try {
			User user = us.checkLogin(email, password);
			request.getSession().setAttribute("user", user);
//		} catch (UsernameException e) {
//			request.getSession().setAttribute("UsernameException", e.getMessage());
//			return "redirect:toLogin.do";
//		} catch (PasswordException e){
//			request.getSession().setAttribute("PasswordException", e.getMessage());
//			return "redirect:toLogin.do";
//		} catch (Exception e){
//			e.printStackTrace();
//		}
		return "redirect:/main/toIndex.do";
	}
	@ExceptionHandler
	public String executeException(Exception e,HttpServletRequest request) throws Exception{
		if(e instanceof UsernameException){
			request.getSession().setAttribute("UsernameException", e.getMessage());
			return "redirect:toLogin.do";
		}else if(e instanceof PasswordException){
			request.getSession().setAttribute("PasswordException", e.getMessage());
			return "redirect:toLogin.do";
		}else{
			throw e;
		}
		
	}
	
	
	
}
