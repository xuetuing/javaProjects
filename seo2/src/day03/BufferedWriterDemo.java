package day03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//�����ַ������
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bw.txt",true);
		
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		/*
		 * BufferedWriter(Writer writer)
		 * ���������ַ������ת��Ϊ�����ַ������
		 */
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("���");
		bw.close();
	}
}
