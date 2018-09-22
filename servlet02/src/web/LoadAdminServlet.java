package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class LoadAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//��ȡidֵ
		int id = Integer.parseInt(req.getParameter("id"));
		//��ȡ��
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		//JDBC����id��ѯ��¼
		Connection con = null;
		try {
			AdminDAO dao = new AdminDAOImpl();
			Admin admin = dao.findById(id);
			if(admin!=null){
				//String ids = rs.getString("id");
				String username = admin.getUsername();
				String password = admin.getPassword();
				String realname = admin.getRealname();
				out.print("<form method='post' action='update'>" +
						"���:<input type='text' name='id' value='"+id+"' readonly/><br/>" +
						"�û�:<input type='text' name='user' value='"+username+"'/><br/>" +
						"����:<input type='password' name='pwd' value='"+password+"'/><br/>" +
						"����:<input type='text' name='name' value='"+realname+"'/><br/>" +
						"<input type='submit' value='�޸�'/></form>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}
}























