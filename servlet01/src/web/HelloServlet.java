package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	//HttpServletResponse����Ӧ����
	//HttpServletRequest���������
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//������������ص���������
		//���õı����ʽ�Ὣ���������������������ʽ������Ϊutf-8
		res.setContentType("text/html;charset=utf-8"); 
		//������Ĭ�ϵĽ����ʽ��ISO8859-1
		//���÷������˵Ľ����ʽ  ֻ��post������Ч
		req.setCharacterEncoding("utf-8");
		
		//��ȡ�������ֵ
		String name = req.getParameter("name");
			
		//��ҳ�����"Hello Servlet"
		//��ȡ�ַ������
		PrintWriter out = res.getWriter();
		//������Ĭ�ϵı����ʽ��ISO8859-1��������ı��벻һ�»ᵼ������
		int id = 2;
		out.print("<span style='color:red'>��� "+name+"!</span>");
		out.print("<a href='load?id=2'>���</a>");
		
		//�ر���
		out.close();
	}
}
