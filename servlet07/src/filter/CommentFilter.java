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
	//FilterChaim:过滤链
	//只有调用了FilterChain的doFilter方法，容器才会调用后续的过滤器，
	//如果没有，则调用后续web组件
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//将父接口转成子接口类型
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String comment = (String)request.getParameter("comment");
		PrintWriter out = response.getWriter();
		if(comment.indexOf("dog")>=0){
			//有敏感字
			out.print("评论内容不合法");
		}else{
			chain.doFilter(req, res);
		}
		out.close();
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init...");
	}

}
