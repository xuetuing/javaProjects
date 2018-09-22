package com.xms.controller;

import org.springframework.stereotype.Component;

//目标组件
@Component
public class TestController {
	public String findAll(){
		System.out.println("查询");
		
//		Integer.parseInt("ABC");
		return "hello";
	}
}
