package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		if("/checkUsername".equals(action)){
			//获取请求参数值
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			String username = request.getParameter("username");
			System.out.println(username);
			if("zhangsan".equals(username)){
				out.print("已被占用");
			}else{
				out.print("可以使用");
				
			}
			//模拟异常
			//throw new ServletException();
			
		}else if("/car".equals(action)){
			String value = request.getParameter("value");
			if("qq".equals(value)){
				out.print("性价比还可以");
			}else if("golf".equals(value)){
				out.print("适合女性");
			}
		}else if("/city".equals(action)){
			String city = request.getParameter("city");
			if("-1".equals(city)){
				out.print("-1:请选择");
			}else if("hn".equals(city)){
				String cs = "-1:请选择;zz:郑州;xy:信阳;ly:洛阳";
				out.print(cs);
			}else if("js".equals(city)){
				String cs = "-1:请选择;nj:南京;sz:苏州;cz:常州";
				out.print(cs);
				
			}
		}
		
		out.close();
	}

}








