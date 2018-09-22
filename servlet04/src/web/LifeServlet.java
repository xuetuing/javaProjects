package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet{
	public LifeServlet(){
		System.out.println("life constructor...");
		
	}
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		System.out.println("life service...");
		ServletConfig config = getServletConfig();
		//获取初始化参数值
		String pageSize = config.getInitParameter("pageSize");
		System.out.println(pageSize);
	}
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		System.out.println("life init...");
//	}
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("life init2...");
	}
	@Override
	public void destroy() {
		//super.destroy();
		System.out.println("life destroy...");
	}
}











