package day03;

import java.util.Calendar;
import java.util.Date;
//Calendar类和Date类的转换
public class Demo1 {
	public static void main(String[] args) {
		//Calendar calendar = new Calendar();
		//通过工厂方法获取实例
		Calendar calendar = Calendar.getInstance();
		//通常我们使用的是格里高利历法
		//Calendar calendar1 = new GregorianCalendar();
		//默认情况下创建的calendar类对象表示的是当前系统时间
		System.out.println(calendar);
		/*
		 * 查看Calendar 的时间，通过输出该对象得到的字符串不友好
		 * 可以先将Calendar转换为Date对象
		 * Date getTime()
		 * 该方法的作用是将当前calendar描述的时间转换为一个Date对象并返回
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		/*
		 * void  setTime()
		 * 使当前Calendar描述给定的Date对象所描述的时间
		 */
		Date now = new Date();
		calendar.setTime(now);
		System.out.println(calendar);
		
		
	}
}
