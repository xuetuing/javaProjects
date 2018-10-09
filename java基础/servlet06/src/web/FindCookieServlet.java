package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//≤È’“Cookie
		Cookie[] cs = request.getCookies();
		if(cs!=null){
			for(Cookie c : cs){
				String name = c.getName();
				String value = URLDecoder.decode(c.getValue(),"utf-8");
				out.print(name+"="+value+"<br/>");
			}
		}else{
			out.print("√ª”–cookie");
			
		}
		out.close();
	}

}
