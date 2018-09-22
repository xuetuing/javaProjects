package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

import util.DBUtil;

public class AddAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		//PrintWriter out = res.getWriter();
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String realname = req.getParameter("realname");
		//out.print(username+","+password+","+realname);
		
		//�����е����ݱ��浽���ݿ�
		//��ȡ����
		try {
			AdminDAO dao = new AdminDAOImpl();
			Admin admin = new Admin(username,password,realname);
			dao.add(admin);
			//out.print("��ӳɹ�<br/>");
			//out.print("<a href='list'>�鿴�б�</a>");
			res.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//out.close();
	}
}











