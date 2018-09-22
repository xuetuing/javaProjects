package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeSessionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡsession
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		//System.out.println(sessionId);
		session.setAttribute("username", "�ܿ�");
		//out.print("�󶨳ɹ�");
		response.sendRedirect(response.encodeRedirectURL("other"));
		out.close();
	}

}
