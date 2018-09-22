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
		//��ȡdao
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		if("/list".equals(action)){
			//�ж�session���Ƿ�����û�����
//			HttpSession session = request.getSession();
//			Object obj = session.getAttribute("admin");
//			if(obj==null){
//				//��¼ʧ��
//				response.sendRedirect("login.jsp");
//				return;
//			}
			try {
//				String str = null;
//				str.length();
				//��ȡҳ��ֵ
				String strPage = request.getParameter("page");
				
				if(strPage==null){
					strPage = "1";
				}
				int page  = Integer.parseInt(strPage);
				List<Admin> list = dao.findAll(page,2);
				int totalPages = dao.getTotalPages(2);
				//��list�󶨵�request
				request.setAttribute("list",list);
				request.setAttribute("page",page);
				request.setAttribute("totalPages",totalPages);
				//��ȡת����
				RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
				//ת��
				rd.forward(request, response);
			} catch (Exception e) {
				//��Ҫ���쳣��Ϣ���浽��־�ļ��У�log4j��
				e.printStackTrace();
				//��service�����׳��쳣
//				throw new ServletException(e);
			}
		}else if("/load".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				Admin admin = dao.findById(id);
				//ת��
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
			//��ȡsession
			HttpSession session = request.getSession();
			//��ȡ������
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String userCode = request.getParameter("userCode");
			//У����֤��
			String rightCode = (String)session.getAttribute("rightCode");
			if(!userCode.equalsIgnoreCase(rightCode)){
				//�����ִ�Сд
				request.setAttribute("code_msg", "��֤�����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			//У���û���������
			try {
				Admin admin = dao.findByUsername(username);
				if(admin!=null&&admin.getPassword().equals(password)){
					//��¼�ɹ�
					//���û���Ϣ�󶨵�session
					session.setAttribute("admin", admin);
					//�ж��û��Ƿ�ѡ�˸�ѡ��
					String auto = request.getParameter("auto");
					if("0".equals(auto)){
						//��ѡ�˸�ѡ��
						//�����ݱ��浽cookie�� 60s
						//����������cookie��
						CookieUtil.addCookie("admin", username+";"+password, 60, response);
					}
					response.sendRedirect("list.do");
				}else{
					//��¼ʧ��
					request.setAttribute("login_msg", "�˺Ż��������");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/logout".equals(action)){
			//ɾ��session�е���Ϣ
			HttpSession session = request.getSession();
			session.invalidate();
			//��ת����¼ҳ��
			response.sendRedirect("login.jsp");
		}
		
		out.close();
	}

}














