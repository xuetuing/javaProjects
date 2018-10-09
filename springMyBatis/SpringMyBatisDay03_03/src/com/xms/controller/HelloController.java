package com.xms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("hello.do")
	public ModelAndView hello(){
		System.out.println("hello spring mvc.");
		
		return new ModelAndView("hello");
	}
}
