package day03;

import java.util.Calendar;

public class CelendarDemo4 {
	public static void main(String[] args) {
		//��������µ��Ǽ��ţ���һ�� �µ�1�ż�һ��
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * void add(int field,int value)
		 * ��������ʱ������ۼӸ�����ֵ
		 */
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_YEAR, -1);
		System.out.println(calendar.getTime());
		
		
	}
}
