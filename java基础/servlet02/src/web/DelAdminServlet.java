package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.AdminDAOImpl;

public class DelAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//��ȡget�����id ����������
		int id = Integer.parseInt(req.getParameter("id"));
		//System.out.println(id);
		//��ȡ��
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		try {
			AdminDAO dao = new AdminDAOImpl();
			dao.del(id);
			res.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}







