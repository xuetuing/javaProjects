package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
//		a = a + b;
//		b = a - b;
//		a = a - b;
//		System.out.println(a+","+b);
		
//		a = a^b;
//		b = a^b;
//		a = a^b;
//		System.out.println(a+","+b);
//		short a = 1;  
//		a += 1; 自动类型转换
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println(sdf.format(date));
	}
	
	
}

