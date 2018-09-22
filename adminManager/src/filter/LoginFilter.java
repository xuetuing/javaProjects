package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CookieUtil;
import dao.AdminDAO;
import entity.Admin;
import factory.DAOFactory;
public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res= (HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//获取session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("admin");
		//获取资源路径
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/login".equals(action)){
			chain.doFilter(req, res);
			return;
		}
		
		//先判断session用于登录拦截，再判断cookie用于自动登录
		if(obj==null){
			//查找cookie中是否包含用户信息
			String value = CookieUtil.findCookie("admin", req);
			
			if(value==null){
				//用户没有选择复选框，或者超时 
				//跳转到登录页面
				res.sendRedirect("login.jsp");
			}else{
				//要对信息进行校验是否正确？？  最新值从哪儿来？
				String username = value.split(";")[0];
				String password = value.split(";")[1];
				AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
				try {
					Admin admin = dao.findByUsername(username);
					if(!password.equals(admin.getPassword())){
						res.sendRedirect("login.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//将cookie中的用户信息备份到session中
				session.setAttribute("admin", value);
				chain.doFilter(req, res);
			}
		}else{
			//登录成功，继续访问后续组件
			chain.doFilter(req, res);
		}
//		String value = CookieUtil.findCookie("admin", req);
//		if(obj==null && value==null){
//			res.sendRedirect("login.jsp");
//		}else{
//			//要对信息进行校验是否正确？？  最新值从哪儿来？
//			String username = value.split(";")[0];
//			String password = value.split(";")[1];
//			AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
//			try {
//				Admin admin = dao.findByUsername(username);
//				if(!password.equals(admin.getPassword())){
//					res.sendRedirect("login.jsp");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			//将cookie中的用户信息备份到session中
//			session.setAttribute("admin", value);
//			chain.doFilter(req, res);
//		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
