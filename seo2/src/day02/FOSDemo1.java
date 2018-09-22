package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件字节输出流
public class FOSDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream(File file)
		 * FileOutputStream(String fileName)
		 * 基于给定的文件名创建用于写文件的输出流
		 */
//		FileOutputStream fos = new FileOutputStream(new File("fos.dat"));
		FileOutputStream fos = new FileOutputStream("fos.dat");
		/*
		 * void write(int d)
		 * 写一个字节，写给定int值的"低8位"
		 * 
		 */
		fos.write('A');
		/*
		 * void write(byte[] b)
		 * 将给定的字节数组中的所有字节一次性写出
		 */
		String str = "学码思";
		byte[] date = str.getBytes("UTF-8");
		fos.write(date);
		/*
		 * void write(byte[] b,int start,int len)
		 */
		fos.close();
	
	}
}



















