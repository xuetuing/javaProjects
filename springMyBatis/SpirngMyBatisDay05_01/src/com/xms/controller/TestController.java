package com.xms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("testOne.do")
	public String testOne() throws ClassNotFoundException{

		//异常
		//java.lang.NumberFormatException
		//Integer.parseInt("ABC");
		
		//java.lang.StringIndexOutOfBoundsException
		//"ABC".charAt(9);
		Class.forName("openclass");
		
		return "jsp/one";
	}
	@ExceptionHandler
	public String executeException(Exception e,
		HttpServletRequest request) throws Exception{
		if(e instanceof ClassNotFoundException){
			request.setAttribute("message", "找不到类");
			return "jsp/message";
		}else{
			throw e;
		}
	}
	
}
