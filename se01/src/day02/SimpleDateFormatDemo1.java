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
		 * ��������Date������������ʱ�䰴��ָ����ʱ���ʽת��Ϊ��Ӧ���ַ���
		 */
		sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		String str = sdf.format(now);
		System.out.println(str);
		
		
	}
}





















