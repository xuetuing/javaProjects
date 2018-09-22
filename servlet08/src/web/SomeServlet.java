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
		//获取上下文对象
		ServletContext sc = this.getServletContext();
		//绑定数据
		sc.setAttribute("username", "jack");
		out.print("绑定成功");
		String version = sc.getInitParameter("version");
		out.print(version);
		out.close();
	}

}
