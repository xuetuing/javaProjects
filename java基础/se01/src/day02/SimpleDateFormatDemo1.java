package day02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo1 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		/*
		 * String format(Date date)
		 * 将给定的Date对象所描述的时间按照指定的时间格式转换为对应的字符串
		 */
		sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String str = sdf.format(now);
		System.out.println(str);
		
		
	}
}





















