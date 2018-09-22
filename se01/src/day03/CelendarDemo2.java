package day03;

import java.util.Calendar;

public class CelendarDemo2 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * int get(int field)
		 * 该参数对应Calendar提供的若干常量，每个常量表示不同的时间单位
		 */
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month+1);
		/*
		 * 对于天，与以下几种时间分量：
		 * Calendar.Date			几号
		 * Calendar.DAY_OF_MONTH	几号
		 * Calendar.DAY_OF_YEAR		年中的天
		 * Calendar.DAY_OF_WEEK		星期几
		 */
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		day = calendar.get(Calendar.DATE);
		System.out.println(day);
		
		day = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(day);
		
		/*
		 * 对于星期，符号美国的习惯
		 * 周日为第一天
		 */
		day = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(day==1?7:(day-1));
	}
}
















