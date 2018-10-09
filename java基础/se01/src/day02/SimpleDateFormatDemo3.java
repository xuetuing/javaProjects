package day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 控制台输入出 生日期，计算到今天为止多少天
 * 输入生日格式：yyyy-MM-dd
 */
public class SimpleDateFormatDemo3 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入生日：");
		String birth = sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birth);
		Date now = new Date();
		long ms = now.getTime();
		long hs = date.getTime();
		long d = (ms-hs)/(24*60*60*1000);
		System.out.println(d);
	}
}
