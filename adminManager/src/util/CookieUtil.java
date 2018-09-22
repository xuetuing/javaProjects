package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	public static final String path = "/adminManager";
	//添加cookie
	public static void addCookie(String name,String value,int age,HttpServletResponse response) 
	throws UnsupportedEncodingException{
		Cookie c = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
	}
	//根据名字查找cookie值
	public static String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException{
		Cookie[] cs = request.getCookies();
		String value = null;
		if(cs!=null){
			for(Cookie c : cs){
				if(c.getName().equals(name)){
					value = URLDecoder.decode(c.getValue(),"UTF-8");
					break;
				}
			}
		}
		return value;
	}
	//删除cookie
	public static void delCookie(String name,HttpServletResponse response){
		Cookie c = new Cookie(name,"");
		c.setPath(path);
		c.setMaxAge(0);
		response.addCookie(c);
	}

}




