package com.xms.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e) {
		System.out.println(obj);
		System.out.println(e);
		if(e instanceof StringIndexOutOfBoundsException){
			System.out.println("1134");
			request.setAttribute("message", "字符串下标越界");
		}else if(e instanceof NumberFormatException){
			System.out.println("564");
			request.setAttribute("message", "数字转换异常");
		}
		
		return new ModelAndView("jsp/message");
	}

}
