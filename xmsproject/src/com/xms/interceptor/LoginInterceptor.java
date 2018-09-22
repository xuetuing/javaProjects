package com.xms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView model) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/main/toDirect.do");
			return false;
		}
		return true;
	}

}
