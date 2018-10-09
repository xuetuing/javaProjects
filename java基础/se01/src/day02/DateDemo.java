package day02;

import java.util.Date;
/*
 * 在设计上存在两个问题：
 * 1.千年虫问题
 * 2.时区问题
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * Date()
		 * 该构造方法创建出来的对象默认表示当前系统时间
		 * 
		 */
		Date now = new Date();
		//System.out.println(now);
		/*
		 * long getTime()
		 * 获取Date描述的时间距离1970年元旦的毫秒差
		 */
		long ms = now.getTime();
		System.out.println(ms);
		
		//计算，明天这一刻的毫秒
//		ms += 24*60*60*1000;
//		System.out.println(ms);
		//创建一个Date对象,描述给定的毫秒值所表示的时间
		Date td = new Date(ms);
		System.out.println(td);
		/*
		 * setTime()
		 * 使当前对象表示 给定的毫秒值所描述的时间
		 */
		now.setTime(ms);
		System.out.println(now);
		
	}
}



















































