package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		//画板
		BufferedImage image = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
		//画笔
		Graphics g = image.getGraphics();
		//画笔上色  画背景
		Random rd = new Random();
		g.setColor(new Color(rd.nextInt(200), rd.nextInt(200), rd.nextInt(200)));
		g.fillRect(0, 0, 80, 40);
		//画字符串
		g.setColor(Color.black);
		g.setFont(new Font(null, Font.BOLD, 20));
		
		String str = getStr(5);
		//将生成的验证码绑定到session
		HttpSession session = request.getSession();
		session.setAttribute("rightCode", str);
		
		g.drawString(str, 6, 30);
		
		//画线条
		for(int i=0;i<5;i++){
			g.setColor(new Color(rd.nextInt(256),rd.nextInt(256),rd.nextInt(256)));
			g.drawLine(rd.nextInt(80), rd.nextInt(40), rd.nextInt(80), rd.nextInt(40));
		}
		//压缩图片
		ImageIO.write(image, "jpeg", os);
		
	}
	
	public String getStr(int length){
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer sbf = new StringBuffer();
		Random rd = new Random();
		for(int i=0;i<length;i++){
			sbf.append(str.charAt(rd.nextInt(str.length())));
		}
		return sbf.toString();
	}
}
