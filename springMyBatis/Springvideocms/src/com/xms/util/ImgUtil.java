package com.xms.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImgUtil {
	
	public static Map<String,BufferedImage> getImage(){
		//创建绘图面板
		BufferedImage image = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
		
		//画笔
		Graphics g = image.getGraphics();
		//画笔上色
		Random rd = new Random();
		g.setColor(new Color(rd.nextInt(200), rd.nextInt(200), rd.nextInt(200)));
		
		//画背景
		g.fillRect(0, 0, 80, 40);
		
		//画字符串
		g.setColor(Color.black);
		g.setFont(new Font(null, Font.BOLD, 20));
		String code = getCode(5);
		g.drawString(code, 8, 30);
		
		//画干扰线
		for(int i=0;i<code.length();i++){
			g.setColor(new Color(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256)));
			g.drawLine(80, 40, 80, 40);
		}
		
		//图片返回
		Map<String,BufferedImage> map = new HashMap<String,BufferedImage>();
		map.put(code, image);
		
		return map;
	}
	
	public static String getCode(int n){
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			char c = str.charAt(rd.nextInt(str.length()));
			sb.append(c);
		}
		
		return sb.toString();
	}
	//进行流转换,将图片转为向网页的输入流
//	public static InputStream getImgStream(BufferedImage img){
//		//创建低级输出流
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		try {
//			//将图片写入到输出流
//			ImageIO.write(img, "jpeg", bos);
//			//转字节数组 
//			byte[] buf = bos.toByteArray();
//			//创建输入流
//			ByteArrayInputStream bis = new ByteArrayInputStream(buf);
//			
//			return bis;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	
}




