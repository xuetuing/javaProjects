package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//ʹ���ļ��ֽ���������������ļ�
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		//����Ŀ¼�µ�tomcat.rar����
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
		System.out.println("��ʱ��"+(end - start)+"����");
		src.close();
		des.close();
		
		
	}
}










