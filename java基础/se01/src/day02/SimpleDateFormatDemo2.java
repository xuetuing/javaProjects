package day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		//��������һ���ַ���ת��Ϊ���ʾ��ʱ��Date
		String str = "2008-08-08 20:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * Date parse(String str)
		 * ��������һ���ַ������ո��������ڸ�ʽ����Ϊ��Ӧ��Date����
		 */
		Date date = sdf.parse(str);
		System.out.println(date);
		
	}
}
