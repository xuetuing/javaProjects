package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ�����Ķ���
		ServletContext sc = this.getServletContext();
		String username = (String)sc.getAttribute("username");
		out.print("username="+username);
		String version = sc.getInitParameter("version");
		out.print(version);
		
		//��ȡ�����ַ
		String path = sc.getRealPath("upload");
		System.out.println(path);
		
		
		out.close();
	}

}
