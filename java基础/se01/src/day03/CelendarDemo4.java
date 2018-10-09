package day03;

import java.util.Calendar;

public class CelendarDemo4 {
	public static void main(String[] args) {
		//计算该月月底是几号：下一个 月的1号减一天
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * void add(int field,int value)
		 * 将给定的时间分量累加给定的值
		 */
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_YEAR, -1);
		System.out.println(calendar.getTime());
		
		
	}
}
