package com.xms.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class MyExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e) {
		request.getSession().invalidate();
		if(e instanceof UsernameException){
			request.getSession().setAttribute("unameMsg", e.getMessage());		
		}else if(e instanceof PasswordException){
			request.getSession().setAttribute("upassMsg", e.getMessage());
		}
		RedirectView view = new RedirectView("toLogin.do");
		
		return new ModelAndView(view);
	}

}
