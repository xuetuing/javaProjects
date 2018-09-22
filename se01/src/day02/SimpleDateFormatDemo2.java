package day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		//将给定的一个字符串转换为其表示的时间Date
		String str = "2008-08-08 20:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * Date parse(String str)
		 * 将给定的一个字符串按照给定的日期格式解析为对应的Date对象
		 */
		Date date = sdf.parse(str);
		System.out.println(date);
		
	}
}
