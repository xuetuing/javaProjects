package day02;

import org.apache.commons.lang3.StringUtils;

/*
 * commons-lang  该包是由Apache组织提供的用于扩展java中
 * lang包的类的一些方法
 */
public class Demo5 {
	public static void main(String[] args) {
		/*
		 * String repeat(String str,int repeat)
		 * 将给定的字符串重复次数的返回
		 */
		String repeat = StringUtils.repeat("abc",5);
		System.out.println(repeat);
		
		String str = "123,456,789";
		String[] array = str.split(",");
		
		/*
		 * join()
		 * 将给定的数组中的每一项按照给定的字符串连接在一起
		 * 这个方法正好是split()的反操作
		 */
		String join = StringUtils.join(array,".");
		System.out.println(join);
		
		/*
		 * String leftPad(String str,int size,char chs)
		 * 将给定的字符串str左侧添加若干个给定的字符chs,以使当前字符串
		 * 达到给定的长度size
		 */
		String str1 = "1234";
		String leftPad = StringUtils.leftPad(str1,10,'*');
		System.out.println(leftPad);
		/*
		 * String rightPad()
		 * 与leftPad()相同，只是在右侧补充字符
		 */
		String rightPad = StringUtils.rightPad(str1,10,'#');
		System.out.println(rightPad);
	}
	
}






















