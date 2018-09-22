package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class FindAddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String value = CookieUtil.findCookie("city", request);
		if(value==null){
			//没找到
			CookieUtil.addCookie("city", "nj", 10, response);
			out.print("创建了新的cookie:city");
		}else{
			out.print(value);
		}
		out.close();
	}

}
