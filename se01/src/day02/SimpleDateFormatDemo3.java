package day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * ����̨����� �����ڣ����㵽����Ϊֹ������
 * �������ո�ʽ��yyyy-MM-dd
 */
public class SimpleDateFormatDemo3 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������գ�");
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
