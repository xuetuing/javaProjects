package com.xms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.xms.entity.User;

@Controller
@RequestMapping("/test")
public class TestController {
	
	//HttpServletRequest接收请求参数
	@RequestMapping("testOne.do")
	public ModelAndView testOne(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		return new ModelAndView("hello");
	}
	//方法参数接收请求参数(@RequestParam注解可以解决)
	//方法参数名和请求参数名不一致
	@RequestMapping("testTwo.do")
	public ModelAndView testTwo(String username,String password){
		
		System.out.println(username);
		System.out.println(password);
		
		return new ModelAndView("hello");
	}
	
	//使用@RequestParam注解指明
	@RequestMapping("testThree.do")
	public ModelAndView testThree(@RequestParam("username")String name,
			@RequestParam("password")String pwd){
		
		System.out.println(name);
		System.out.println(pwd);
		
		return new ModelAndView("hello");
	}
	//封装Bean对象接收参数
	@RequestMapping("testFour.do")
	public ModelAndView testFour(User user){
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		return new ModelAndView("hello");
	}
	//ModelAndView传递数据
	@RequestMapping("testFive.do")
	public ModelAndView testFive(){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("success", true);
		data.put("message", "操作成功");
		
		//默认是在request中的
		return new ModelAndView("hello",data);
	}
	//ModelMap类型参数传递数据
	@RequestMapping("testSix.do")
	public ModelAndView testSix(ModelMap modelMap){
		modelMap.addAttribute("success", false);
		modelMap.addAttribute("message","操作失败");
		
		return new ModelAndView("hello");
	}
	
	//@ModelAttribute传递属性值
	@Value("25")
	private Integer age;
	@ModelAttribute("age")
	public Integer getAge() {
		return age;
	}
	//@ModelAttribute注解传递数据
	@RequestMapping("testSeven.do")
	public ModelAndView testSeven(@ModelAttribute("username")String username){
		//@ModelAttribute的username即是接收者也是传递者
		//这种情况下是先根据'username'查找值，再赋给参数username,参数username的值再赋给注解username
		return new ModelAndView("hello");
	}
	
	@RequestMapping("testEight.do")
	public String testEight(){
		return "error"; //返回的就是视图名称
	}
	//RedirectView重定向
	@RequestMapping("testNine.do")
	public ModelAndView testNine(){
		RedirectView view = new RedirectView("testEight.do");
		return new ModelAndView(view);
	}
	//redirect:前缀
	@RequestMapping("testTen.do")
	public String testTen(){
		return "redirect:testEight.do";
	}
}



















