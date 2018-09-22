package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter{

	public void destroy() {
		
	}
	//FilterChaim:������
	//ֻ�е�����FilterChain��doFilter�����������Ż���ú����Ĺ�������
	//���û�У�����ú���web���
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//�����ӿ�ת���ӽӿ�����
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String comment = (String)request.getParameter("comment");
		PrintWriter out = response.getWriter();
		if(comment.indexOf("dog")>=0){
			//��������
			out.print("�������ݲ��Ϸ�");
		}else{
			chain.doFilter(req, res);
		}
		out.close();
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init...");
	}

}
