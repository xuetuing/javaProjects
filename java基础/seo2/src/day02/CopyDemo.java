package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//使用文件字节输入输出流复制文件
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		//将根目录下的tomcat.rar复制
		FileInputStream src = new FileInputStream("tomcat.rar");
		FileOutputStream des = new FileOutputStream("tomcat3.rar");
		long start = System.currentTimeMillis();
//		int d = -1;
//		while((d=src.read())!=-1){
//			des.write(d);
//		}
		int d = -1;
		byte[] buffer = new byte[1024*10];
		while((d=src.read(buffer))!=-1){
			des.write(buffer,0,d);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end - start)+"毫秒");
		src.close();
		des.close();
		
		
	}
}










