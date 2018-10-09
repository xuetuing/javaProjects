package day01;

import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		String str = "Thinking in java";
		String sub = str.substring(9, 11);
		//System.out.println(sub);
		
		sub = str.substring(12);
		//System.out.println(sub);
		
		String str1 = "从指定位置开始";
		char[] chs = str1.toCharArray();
		//System.out.println(chs);//字符串
		System.out.println(chs.toString());//地址
		//System.out.println(Arrays.toString(chs));//数组
		//str = Arrays.toString(chs);//返回的内容会带有"[]"
		String str2 = new String(chs);
		System.out.println(str2);
		
		
	}
}




















