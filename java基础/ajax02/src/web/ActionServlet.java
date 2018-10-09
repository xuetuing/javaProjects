package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import dao.SaleDAO;
import dao.SaleDAOImpl;
import entity.Car;
import entity.Sale;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = (String)request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		if("/car".equals(action)){
			String value = (String)request.getParameter("value");
			Car car = null;
			if("qq".equals(value)){
				car = new Car("QQ","good");
				
			}else if("golf".equals(value)){
				car = new Car("GOLF","great");
			}
			String data = JSONObject.fromObject(car).toString();
			out.print(data);
			//throw new ServletException();
		}else if("/sale".equals(action)){
			SaleDAO dao = new SaleDAOImpl();
			try {
				List<Sale> list = dao.findTop();
				String data = JSONArray.fromObject(list).toString();
				out.print(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		out.close();
	}

}
