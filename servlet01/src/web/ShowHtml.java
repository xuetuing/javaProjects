package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHtml extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//��ȡ��
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		req.setCharacterEncoding("utf-8");
		out.print("����ɹ���");
		out.close();
	}
}
