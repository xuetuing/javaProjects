package day03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		//���������������ļ����������󹹽������
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String str = "��Һ�";
		byte[] b = str.getBytes("UTF-8");
		bos.write(b);
		//���������д���󣬱���ͨ��flush()������д���ļ�
		bos.flush();
		/*
		 * �ڹر�����ʱ������ֻ��Ҫ�ر������ĸ߼������ɣ�
		 * �߼����ڹر�ʱ���Ƚ���������ر��ٹر�����
		 */
		bos.close();
		
		
	}
}


































