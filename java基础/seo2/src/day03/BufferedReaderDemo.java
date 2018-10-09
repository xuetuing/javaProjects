package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =
			new FileInputStream("bw.txt");
		InputStreamReader isr =
			new InputStreamReader(fis,"UTF-8");
//		FileReader fr = new FileReader("bw.txt");
		BufferedReader br = 
			new BufferedReader(isr);
//			new BufferedReader(fr);
		/*
		 * String readLine()
		 * һ�ζ�ȡһ���ַ���
		 * ������ȡ���ɸ��ַ���ֱ���������з�Ϊֹ��
		 * ���ص��ַ����в��������з�
		 */
		String str = br.readLine();
		System.out.println(str);
		//�����ַ�������readLine()����������null,��˵��EOF
		str = br.readLine();
		System.out.println(str);
		br.close();
	}
}
