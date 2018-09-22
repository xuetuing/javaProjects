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

public class CommentFilter2 implements Filter {
	private FilterConfig config;
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter2...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String comment = request.getParameter("comment");
		int size = Integer.parseInt(config.getInitParameter("size"));
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		if(comment.length()>size){
			out.print("ÆÀÂÛ×ÖÊý³¬³ö·¶Î§");
		}else{
			chain.doFilter(req, res);
		}
		out.close();
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter2 init...");
		this.config = filterConfig;
		
	}

}









