package web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class UpdateAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//��ȡ������
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		//System.out.println(id+","+user+","+pwd+","+name);
		//�������ݸ��� id���ɸ�
		Connection con = null;
		try {
			AdminDAO dao = new AdminDAOImpl();
			Admin admin = new Admin(id,user,pwd,name);
			dao.update(admin);
			res.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









