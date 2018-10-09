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
		//��ȡsession
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("admin");
		//��ȡ��Դ·��
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/login".equals(action)){
			chain.doFilter(req, res);
			return;
		}
		
		//���ж�session���ڵ�¼���أ����ж�cookie�����Զ���¼
		if(obj==null){
			//����cookie���Ƿ�����û���Ϣ
			String value = CookieUtil.findCookie("admin", req);
			
			if(value==null){
				//�û�û��ѡ��ѡ�򣬻��߳�ʱ 
				//��ת����¼ҳ��
				res.sendRedirect("login.jsp");
			}else{
				//Ҫ����Ϣ����У���Ƿ���ȷ����  ����ֵ���Ķ�����
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
				//��cookie�е��û���Ϣ���ݵ�session��
				session.setAttribute("admin", value);
				chain.doFilter(req, res);
			}
		}else{
			//��¼�ɹ����������ʺ������
			chain.doFilter(req, res);
		}
//		String value = CookieUtil.findCookie("admin", req);
//		if(obj==null && value==null){
//			res.sendRedirect("login.jsp");
//		}else{
//			//Ҫ����Ϣ����У���Ƿ���ȷ����  ����ֵ���Ķ�����
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
//			//��cookie�е��û���Ϣ���ݵ�session��
//			session.setAttribute("admin", value);
//			chain.doFilter(req, res);
//		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
