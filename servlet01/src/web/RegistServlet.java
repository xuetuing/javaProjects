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
		//��ȡ��
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//��ȡ������Ϣ
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//��ȡ��ѡ������ name��Ӧ��Ӧ���ֵ
		String[] ints = req.getParameterValues("interest");
		//��ȡ��ѡ��ť����
		String sex = req.getParameter("sex");
		
		out.print(username+","+password+","+Arrays.toString(ints)+","+sex);
		out.close();
	}
}
