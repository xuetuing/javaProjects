package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//Ϊ�������ṩ��ȱʡ������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//����������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			//parseRequest�ײ��ȥ����request.getInputStream()��ȡ������
			//�ٷ�������������ת��һ������FileItem����һ��FileItem��Ӧһ����
			//����
			List<FileItem> items = sfu.parseRequest(request);
			for(FileItem item : items){
				if(item.isFormField()){
					//��ͨ����
					String value = item.getString("utf-8");
					System.out.println(value);
				}else{
					//��ȡ�����Ķ���
					ServletContext sc = this.getServletContext();
					String path = sc.getRealPath("upload");
					//��ȡԴ�ļ�����
					String name = item.getName();
					File file = new File(path+"/"+name);
					item.write(file);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		out.close();
	}

}


















