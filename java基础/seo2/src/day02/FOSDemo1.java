package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//�ļ��ֽ������
public class FOSDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream(File file)
		 * FileOutputStream(String fileName)
		 * ���ڸ������ļ�����������д�ļ��������
		 */
//		FileOutputStream fos = new FileOutputStream(new File("fos.dat"));
		FileOutputStream fos = new FileOutputStream("fos.dat");
		/*
		 * void write(int d)
		 * дһ���ֽڣ�д����intֵ��"��8λ"
		 * 
		 */
		fos.write('A');
		/*
		 * void write(byte[] b)
		 * ���������ֽ������е������ֽ�һ����д��
		 */
		String str = "ѧ��˼";
		byte[] date = str.getBytes("UTF-8");
		fos.write(date);
		/*
		 * void write(byte[] b,int start,int len)
		 */
		fos.close();
	
	}
}



















