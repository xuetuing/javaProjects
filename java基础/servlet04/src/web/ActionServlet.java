package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		String uri = req.getRequestURI();
		System.out.println(uri);
		//分析
		if("/servlet02/list.do".equals(uri)){
			System.out.println("处理列表请求");
		}
		
	}
}
