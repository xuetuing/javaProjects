package day03;

import java.util.Calendar;

public class CelendarDemo2 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * int get(int field)
		 * �ò�����ӦCalendar�ṩ�����ɳ�����ÿ��������ʾ��ͬ��ʱ�䵥λ
		 */
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month+1);
		/*
		 * �����죬�����¼���ʱ�������
		 * Calendar.Date			����
		 * Calendar.DAY_OF_MONTH	����
		 * Calendar.DAY_OF_YEAR		���е���
		 * Calendar.DAY_OF_WEEK		���ڼ�
		 */
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		day = calendar.get(Calendar.DATE);
		System.out.println(day);
		
		day = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(day);
		
		/*
		 * �������ڣ�����������ϰ��
		 * ����Ϊ��һ��
		 */
		day = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(day==1?7:(day-1));
	}
}
















