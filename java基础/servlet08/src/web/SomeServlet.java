package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ�����Ķ���
		ServletContext sc = this.getServletContext();
		//������
		sc.setAttribute("username", "jack");
		out.print("�󶨳ɹ�");
		String version = sc.getInitParameter("version");
		out.print(version);
		out.close();
	}

}
