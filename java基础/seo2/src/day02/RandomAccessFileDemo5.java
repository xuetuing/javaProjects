package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//复制文件
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws IOException {
		//用于读取原文件
		RandomAccessFile src = new RandomAccessFile("tomcat.rar","r");
		//用于写文件
		RandomAccessFile des = new RandomAccessFile("tomcatcp1.rar","rw");
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read())!=-1){
			des.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end - start)+"毫秒");
		
		src.close();
		des.close();
		
		
	}
}




































