package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * ����������ڣ�
 * 1.����̨�����������ڣ�yyyy-MM-dd��
 * 2.����̨���뱣��������
 * 3.���������ǵ��������Ǹ����ڵ�ǰ�������ڵ�������
 * �󣺴�������=��
 */
public class CalendarDemo5 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����������ڣ�");
		String date = sc.next();
		System.out.print("���뱣����������");
		int days = sc.nextInt();
		SimpleDateFormat style = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = style.parse(date);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		//calendar.add(Calendar.WEEK_OF_MONTH, -2);
		calendar.add(Calendar.WEEK_OF_YEAR, -2);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		date1 = calendar.getTime();
		date = style.format(date1);
		System.out.println(date);
	}
}








































