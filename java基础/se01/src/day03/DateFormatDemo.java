package day03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {
	public static void main(String[] args) {
		Date now = new Date();
//		System.out.println(now);
		/*
		 * ����DateFormat��ʵ��ʹ���������ṩ�Ĺ�������
		 * getDateInstance()
		 */
		//DateFormat df = new DateFormat();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);
		String str = df.format(now);
		System.out.println(str);
		
	}
}
