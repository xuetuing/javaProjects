package day03;

import java.util.Calendar;

public class CelendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * void set(int field,int value)
		 * ���õ�ǰCalendar��ָ��ʱ�������ֵ
		 */
		System.out.println(calendar.getTime());
		/*
		 * ����Ϊ2008��
		 */
		calendar.set(Calendar.YEAR,2008);
		calendar.set(Calendar.MONTH,Calendar.AUGUST);
		calendar.set(Calendar.DATE,8);
		calendar.set(Calendar.DAY_OF_MONTH,8);
//		calendar.set(Calendar.DAY_OF_MONTH,32);
//		calendar.set(Calendar.DAY_OF_MONTH,-1);//7.30
		calendar.set(Calendar.DAY_OF_MONTH,0); //7.31
		/*
		 * ������ʱ�������Ӧ��ֵ�����˵�ǰʱ���������������ֵ/��Сֵ
		 * ���Զ���λ����λ
		 */
		System.out.println(calendar.getTime());
		
	}
}
