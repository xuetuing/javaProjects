package day01;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo6 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "我爱python";
		byte[] gbk = str.getBytes("GBK");//英文占一个字节
		System.out.println(gbk.length);
		System.out.println(Arrays.toString(gbk));
		
		byte[] utf = str.getBytes("utf-8");
		System.out.println(utf.length);
		System.out.println(Arrays.toString(utf));
		
		/*
		 * String(byte[] dta,String charserName)
		 * 解码过程
		 */
		String utfStr = new String(utf,"UTF-8");
		System.out.println(utfStr);
		
		
		//从字符串转化为字节序列（字节码）的过程称为编码
		//从字节序列（字节码）转化为字符串的过程称为解码
	}
}




















