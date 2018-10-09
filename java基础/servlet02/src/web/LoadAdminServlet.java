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
		//获取id值
		int id = Integer.parseInt(req.getParameter("id"));
		//获取流
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		//JDBC根据id查询记录
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
						"序号:<input type='text' name='id' value='"+id+"' readonly/><br/>" +
						"用户:<input type='text' name='user' value='"+username+"'/><br/>" +
						"密码:<input type='password' name='pwd' value='"+password+"'/><br/>" +
						"姓名:<input type='text' name='name' value='"+realname+"'/><br/>" +
						"<input type='submit' value='修改'/></form>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}
}























