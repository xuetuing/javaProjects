package day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		/*
		 * OutputStreamWriter(OutputStream out,String csn)
		 * 使用给定的字符集将字符写出
		 */
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		/*
		 * void write(int d)
		 * 写一个字符(char),写给定的int值的"低16位"
		 * 
		 * void write(char[] c)
		 * 一次性将给定字符数组中的所有字符写出
		 * 
		 * void write(char[] c,int start,int len)
		 * 将给定字符数组中从start处开始连续将len个字符写出
		 * 
		 * void write(String str)
		 * 将给定的字符串转换为字符后写出
		 * 
		 * void write(String str,int start,int len)
		 * 将给定的字符串中从start处开始连续将len个字符写出
		 */
		//默认情况下，write()方法会将当前字符串按照系统的默认字符集转换为字节后写出
		osw.write("大家好");
		osw.close();
	}
}
