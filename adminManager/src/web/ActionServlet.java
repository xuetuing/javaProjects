package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CookieUtil;

import dao.AdminDAO;
import entity.Admin;
import factory.DAOFactory;

public class ActionServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		//获取dao
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		if("/list".equals(action)){
			//判断session中是否包含用户数据
//			HttpSession session = request.getSession();
//			Object obj = session.getAttribute("admin");
//			if(obj==null){
//				//登录失败
//				response.sendRedirect("login.jsp");
//				return;
//			}
			try {
//				String str = null;
//				str.length();
				//获取页码值
				String strPage = request.getParameter("page");
				
				if(strPage==null){
					strPage = "1";
				}
				int page  = Integer.parseInt(strPage);
				List<Admin> list = dao.findAll(page,2);
				int totalPages = dao.getTotalPages(2);
				//将list绑定到request
				request.setAttribute("list",list);
				request.setAttribute("page",page);
				request.setAttribute("totalPages",totalPages);
				//获取转发器
				RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
				//转发
				rd.forward(request, response);
			} catch (Exception e) {
				//还要把异常信息保存到日志文件中（log4j）
				e.printStackTrace();
				//向service方法抛出异常
//				throw new ServletException(e);
			}
		}else if("/load".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				Admin admin = dao.findById(id);
				//转发
				request.setAttribute("admin", admin);
				request.getRequestDispatcher("update.jsp").forward(request,response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("/update".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String realname = request.getParameter("realname");
			Admin admin = new Admin(id,username,password,realname);
			try {
				dao.update(admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list.do");
		}else if("/add".equals(action)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String realname = request.getParameter("realname");
			Admin admin = new Admin(username,password,realname);
			try {
				dao.add(admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list.do");
		}else if("/del".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				dao.del(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list.do");
		}else if("/login".equals(action)){
			//获取session
			HttpSession session = request.getSession();
			//获取表单数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String userCode = request.getParameter("userCode");
			//校验验证码
			String rightCode = (String)session.getAttribute("rightCode");
			if(!userCode.equalsIgnoreCase(rightCode)){
				//不区分大小写
				request.setAttribute("code_msg", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			//校验用户名和密码
			try {
				Admin admin = dao.findByUsername(username);
				if(admin!=null&&admin.getPassword().equals(password)){
					//登录成功
					//将用户信息绑定到session
					session.setAttribute("admin", admin);
					//判断用户是否勾选了复选框
					String auto = request.getParameter("auto");
					if("0".equals(auto)){
						//勾选了复选框
						//将数据保存到cookie中 60s
						//下面算两个cookie吗
						CookieUtil.addCookie("admin", username+";"+password, 60, response);
					}
					response.sendRedirect("list.do");
				}else{
					//登录失败
					request.setAttribute("login_msg", "账号或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/logout".equals(action)){
			//删除session中的信息
			HttpSession session = request.getSession();
			session.invalidate();
			//跳转到登录页面
			response.sendRedirect("login.jsp");
		}
		
		out.close();
	}

}














