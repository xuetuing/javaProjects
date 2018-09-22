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
			//��ȡ�������ֵ
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			String username = request.getParameter("username");
			System.out.println(username);
			if("zhangsan".equals(username)){
				out.print("�ѱ�ռ��");
			}else{
				out.print("����ʹ��");
				
			}
			//ģ���쳣
			//throw new ServletException();
			
		}else if("/car".equals(action)){
			String value = request.getParameter("value");
			if("qq".equals(value)){
				out.print("�Լ۱Ȼ�����");
			}else if("golf".equals(value)){
				out.print("�ʺ�Ů��");
			}
		}else if("/city".equals(action)){
			String city = request.getParameter("city");
			if("-1".equals(city)){
				out.print("-1:��ѡ��");
			}else if("hn".equals(city)){
				String cs = "-1:��ѡ��;zz:֣��;xy:����;ly:����";
				out.print(cs);
			}else if("js".equals(city)){
				String cs = "-1:��ѡ��;nj:�Ͼ�;sz:����;cz:����";
				out.print(cs);
				
			}
		}
		
		out.close();
	}

}








