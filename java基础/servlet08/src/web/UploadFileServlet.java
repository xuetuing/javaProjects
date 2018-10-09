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
		//为解析器提供了缺省的配置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//创建解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			//parseRequest底层会去调用request.getInputStream()获取流数据
			//再分析，将流数据转成一个个的FileItem对象，一个FileItem对应一个文
			//本域。
			List<FileItem> items = sfu.parseRequest(request);
			for(FileItem item : items){
				if(item.isFormField()){
					//普通表单域
					String value = item.getString("utf-8");
					System.out.println(value);
				}else{
					//获取上下文对象
					ServletContext sc = this.getServletContext();
					String path = sc.getRealPath("upload");
					//获取源文件名称
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


















