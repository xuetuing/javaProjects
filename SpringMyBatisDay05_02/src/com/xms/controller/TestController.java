package com.xms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("testOne.do")
	public String testOne(){
		System.out.println("testOne");
		return "jsp/hello";
	}
	@RequestMapping("testTwo.do")
	public String testTwo(){
		System.out.println("testTwo");
		return "jsp/hello";
	}
	@RequestMapping("testThree.do")
	public String testThree(){
		System.out.println("testThree");
		return "jsp/hello";
	}
}
