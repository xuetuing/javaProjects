package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo2 {
	public static void main(String[] args) throws IOException {
		//FileOutputStream fos = new FileOutputStream("fos.dat");
		/*
		 * FileOutputStream(String fileName,boolean append)
		 * �ڵ�ǰ�ļ���׷��д����
		 */
	
		FileOutputStream fos = new FileOutputStream("fos.dat",true);
		//������д������ʱ�����ļ�ԭ������ȫ��������
		fos.write('B');
		fos.close();

		
	}
}































