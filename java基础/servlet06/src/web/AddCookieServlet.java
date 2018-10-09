package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//����cookie
		Cookie c = new Cookie("username",URLEncoder.encode("�ܿ�","utf-8"));
		//��ӵ���Ӧ������
		response.addCookie(c);
		
		Cookie c2 = new Cookie("password","123");
		c2.setMaxAge(30);
		response.addCookie(c2);
		
		out.print("��ӳɹ�");
		out.close();
	}

}
