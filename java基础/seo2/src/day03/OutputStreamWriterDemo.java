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
		 * ʹ�ø������ַ������ַ�д��
		 */
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		/*
		 * void write(int d)
		 * дһ���ַ�(char),д������intֵ��"��16λ"
		 * 
		 * void write(char[] c)
		 * һ���Խ������ַ������е������ַ�д��
		 * 
		 * void write(char[] c,int start,int len)
		 * �������ַ������д�start����ʼ������len���ַ�д��
		 * 
		 * void write(String str)
		 * ���������ַ���ת��Ϊ�ַ���д��
		 * 
		 * void write(String str,int start,int len)
		 * ���������ַ����д�start����ʼ������len���ַ�д��
		 */
		//Ĭ������£�write()�����Ὣ��ǰ�ַ�������ϵͳ��Ĭ���ַ���ת��Ϊ�ֽں�д��
		osw.write("��Һ�");
		osw.close();
	}
}
