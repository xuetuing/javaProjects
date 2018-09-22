package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

//���ڻ���ĸ����ļ�����
public class RandomAccessFileDemo6 {
	public static void main(String[] args) throws IOException {
		//���ڶ�ȡԭ�ļ�
		RandomAccessFile src = new RandomAccessFile("tomcat.rar","r");
		//����д�ļ�
		RandomAccessFile des = new RandomAccessFile("tomcatcp2.rar","rw");
		//����һ��������ֽ�����
		byte[] buffer = new byte[1024*10];
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read(buffer))!=-1){   //src.read(buffer)����ֵΪbuffer�ĳ���
			/*
			 * write(byte[] b,int start,int len)
			 * ���������ֽ������д�start��ʼ������len���ֽ�д��
			 */
			//des.write(buffer);
			des.write(buffer,0,d);
		}
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��"+(end - start)+"����");
		
		src.close();
		des.close();
		
		
	}
}






















