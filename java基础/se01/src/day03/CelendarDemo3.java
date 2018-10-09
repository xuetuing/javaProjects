package day03;

import java.util.Calendar;

public class CelendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * void set(int field,int value)
		 * 设置当前Calendar的指定时间分量的值
		 */
		System.out.println(calendar.getTime());
		/*
		 * 设置为2008年
		 */
		calendar.set(Calendar.YEAR,2008);
		calendar.set(Calendar.MONTH,Calendar.AUGUST);
		calendar.set(Calendar.DATE,8);
		calendar.set(Calendar.DAY_OF_MONTH,8);
//		calendar.set(Calendar.DAY_OF_MONTH,32);
//		calendar.set(Calendar.DAY_OF_MONTH,-1);//7.30
		calendar.set(Calendar.DAY_OF_MONTH,0); //7.31
		/*
		 * 当给定时间分量对应的值超出了当前时间分量所允许的最大值/最小值
		 * 会自动进位或退位
		 */
		System.out.println(calendar.getTime());
		
	}
}
