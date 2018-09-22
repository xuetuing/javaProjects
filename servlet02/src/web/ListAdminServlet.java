package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;
import factory.DAOFactory;

public class ListAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//req.setCharacterEncoding("utf-8");

		try {
			//AdminDAO dao = new AdminDAOImpl();
			AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
			List<Admin> list = dao.findAll();
			out.println("<table border='1px' cellspacing='0' width='40%' heigth='30%'>");
			out.println("<tr>");
			out.println("<td>id</td>");
			out.println("<td>username</td>");
			out.println("<td>password</td>");
			out.println("<td>realname</td>");
			out.println("<td>operate</td>");
			out.println("</tr>");
			int count = 1;
			for(Admin admin:list){
				int id = admin.getId();
				String username = admin.getUsername();
				String password = admin.getPassword();
				String realname = admin.getRealname();
//				out.println("<tr>");
//				out.println("<td>"+id+"</td>");
//				out.println("<td>"+username+"</td>");
//				out.println("<td>"+password+"</td>");
//				out.println("<td>"+realname+"</td>");
//				out.println("</tr>");
				//用一个print来打印
				//out.print("<tr><td>"+id+"</td>" +
				out.print("<tr><td>"+(count++)+"</td>" +
						"<td>"+username+"</td>" +
						"<td>"+password+"</td>" +
						"<td>"+realname+"</td>" +
						//"<td><a href="+String.format("'load?id=%d'",id)+">修改</a>|" +
						//"<a href="+String.format("'del?id=%d'",id)+">删除</a></td></tr>");
						"<td><a href='load?id="+id+"'>修改</a>|" +
						"<a href='del?id="+id+"'>删除</a></td></tr>");
			}
			out.println("</table>");
			out.println("<a href='add.html'>添加管理员</a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}
}








