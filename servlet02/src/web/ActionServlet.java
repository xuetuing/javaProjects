package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;
import factory.DAOFactory;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		//截取
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		//分析
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		if("/list".equals(action)){
			try {
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
					out.print("<tr><td>"+(count++)+"</td>" +
							"<td>"+username+"</td>" +
							"<td>"+password+"</td>" +
							"<td>"+realname+"</td>" +
							"<td><a href='load.do?id="+id+"'>修改</a>|" +
							"<a href='del.do?id="+id+"'>删除</a></td></tr>");
				}
				out.println("</table>");
				out.println("<a href='add.html'>添加管理员</a>");
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.close();
		
		}else if("/add".equals(action)){
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String realname = req.getParameter("realname");
			try {
				Admin admin = new Admin(username,password,realname);
				dao.add(admin);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/del".equals(action)){
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.del(id);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/load".equals(action)){
			//获取id值
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				Admin admin = dao.findById(id);
				if(admin!=null){
					String username = admin.getUsername();
					String password = admin.getPassword();
					String realname = admin.getRealname();
					out.print("<form method='post' action='update.do'>" +
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
		
		}else if("/update".equals(action)){
			int id = Integer.parseInt(req.getParameter("id"));
			String user = req.getParameter("user");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			Connection con = null;
			try {
				Admin admin = new Admin(id,user,pwd,name);
				dao.update(admin);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
