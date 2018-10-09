package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet{
	public SomeServlet(){
		System.out.println("someServlet constructor...");
	}
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		System.out.println("some service....");
		
	}
}
