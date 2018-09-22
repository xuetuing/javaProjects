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

import dao.EmpDAO;
import entity.Emp;
import entity.User;
import factory.DAOFactory;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		EmpDAO dao = (EmpDAO)DAOFactory.getInstance("EmpDAO");
		if("/list".equals(action)){
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj==null){
				response.sendRedirect("login.jsp");
				return;
			}
			try {
				//System.out.println("list.........");
				List<Emp> list = dao.findAll();
				request.setAttribute("list",list);
				RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/load".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				Emp emp = dao.findById(id);
				request.setAttribute("emp", emp);
				RequestDispatcher rd = request.getRequestDispatcher("updateEmp.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("/addEmp".equals(action)){
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Emp emp = new Emp(name,salary,age);
			try {
				dao.add_emp(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("/addUser".equals(action)){
			String username = request.getParameter("username");
			User usr = null;
			try {
				usr = dao.findByUsername(username);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(usr!=null){
				request.setAttribute("regist_msg", "用户名已存在");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			}else{
				String realname = request.getParameter("name");
				String password = request.getParameter("pwd");
				String sex = request.getParameter("sex");
				User user = new User(username,realname,password,sex);
				try {
					dao.add_user(user);
					response.sendRedirect("login.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}else if("/update".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Emp emp = new Emp(id,name,salary,age);
			try {
				dao.update_emp(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/del".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				dao.del_emp(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/login".equals(action)){
			String username = request.getParameter("name");
			String password = request.getParameter("pwd");
			//获取用户输入的验证码
			String userCode = request.getParameter("userCode");
			User user = null;
			//获取自动生成的验证码
			HttpSession session = request.getSession();
			String rightCode = (String)session.getAttribute("rightCode");
			if(!userCode.equalsIgnoreCase(rightCode)){
				request.setAttribute("code_msg", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			//先判断验证码   
			try {
				user = dao.findByUsername(username);
				if(user!=null && password.equals(user.getPassword())){
					session.setAttribute("user", user);
					response.sendRedirect("list.do");
				}else{
					request.setAttribute("login_msg", "用户名或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/logout".equals(action)){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		}
		out.close();
	}
}







