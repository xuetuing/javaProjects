package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	//HttpServletResponse：响应对象
	//HttpServletRequest：请求对象
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//告诉浏览器返回的数据类型
		//设置的编码格式会将服务器编码和浏览器解码格式都设置为utf-8
		res.setContentType("text/html;charset=utf-8"); 
		//服务器默认的解码格式是ISO8859-1
		//设置服务器端的解码格式  只对post请求有效
		req.setCharacterEncoding("utf-8");
		
		//获取请求参数值
		String name = req.getParameter("name");
			
		//向页面输出"Hello Servlet"
		//获取字符输出流
		PrintWriter out = res.getWriter();
		//服务器默认的编码格式是ISO8859-1与浏览器的编码不一致会导致乱码
		int id = 2;
		out.print("<span style='color:red'>你好 "+name+"!</span>");
		out.print("<a href='load?id=2'>添加</a>");
		
		//关闭流
		out.close();
	}
}
