package day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//�ַ�������
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		/*
		 * int read()
		 * ��ȡһ���ַ�����intֵ����ʽ���أ���intֵ"��16λ"��Ч
		 * 
		 * int read(char[] c)
		 * һ����ೢ�Զ�ȡ���������length()���ַ������������飬
		 * ����ֵΪʵ�ʶ�ȡ�����ַ���
		 * 
		 * int read(char[] c,int start,int len)
		 * �������ַ������д�start����ʼ������ȡlen���ַ�
		 */
		int c = -1;
		while((c=isr.read())!=-1){
			System.out.println((char)c);
		}
		isr.close();
	}
}
