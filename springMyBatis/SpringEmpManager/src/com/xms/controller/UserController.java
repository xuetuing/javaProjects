package com.xms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xms.entity.Emp;
import com.xms.entity.User;
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
//		try {
			User user = us.checkLogin(username, password);
			request.getSession().setAttribute("user", user);
//		} catch (UsernameException e) {
//			request.getSession().setAttribute("unameMsg", e.getMessage());
//			return "redirect:toLogin.do";
//		} catch (PasswordException e){
//			request.getSession().setAttribute("upassMsg", e.getMessage());
//			return "redirect:toLogin.do";
//		} catch (Exception e){
//			throw e;
//		}
		return "redirect:toList.do";
	}
	@RequestMapping("toList.do")
	public ModelAndView toList(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<Emp> emps = us.getEmpList();
			map.put("empList", emps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("jsp/emplist",map);
	}
}






