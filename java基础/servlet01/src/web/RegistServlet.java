package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//获取流
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//获取表单的信息
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//获取复选框数据 name对应对应多个值
		String[] ints = req.getParameterValues("interest");
		//获取单选按钮数据
		String sex = req.getParameter("sex");
		
		out.print(username+","+password+","+Arrays.toString(ints)+","+sex);
		out.close();
	}
}
