package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class someServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		//out.print("username="+username);
		//重定向到test1.jsp
		//response.sendRedirect("/servlet05/jsp1/test1.jsp");
		//转发到test1.jap
		request.getRequestDispatcher("/jsp1/test1.jsp").forward(request, response);
		out.close();
	}

}
