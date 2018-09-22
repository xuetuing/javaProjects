package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

//基于缓存的复制文件操作
public class RandomAccessFileDemo6 {
	public static void main(String[] args) throws IOException {
		//用于读取原文件
		RandomAccessFile src = new RandomAccessFile("tomcat.rar","r");
		//用于写文件
		RandomAccessFile des = new RandomAccessFile("tomcatcp2.rar","rw");
		//创建一个缓存的字节数组
		byte[] buffer = new byte[1024*10];
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read(buffer))!=-1){   //src.read(buffer)返回值为buffer的长度
			/*
			 * write(byte[] b,int start,int len)
			 * 将给定的字节数组中从start开始连续将len个字节写出
			 */
			//des.write(buffer);
			des.write(buffer,0,d);
		}
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end - start)+"毫秒");
		
		src.close();
		des.close();
		
		
	}
}






















