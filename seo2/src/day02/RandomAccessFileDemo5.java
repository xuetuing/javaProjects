package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//�����ļ�
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws IOException {
		//���ڶ�ȡԭ�ļ�
		RandomAccessFile src = new RandomAccessFile("tomcat.rar","r");
		//����д�ļ�
		RandomAccessFile des = new RandomAccessFile("tomcatcp1.rar","rw");
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read())!=-1){
			des.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��"+(end - start)+"����");
		
		src.close();
		des.close();
		
		
	}
}




































