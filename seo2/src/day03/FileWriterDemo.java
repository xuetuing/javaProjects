package day03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//�����ַ������
public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * FileWriter(File file)
		 * FileWriter(String fileName)
		 * ����ֱ�Ӷ��ļ�д�ַ���ʹ��FW����FR��Ĭ�������
		 * ʹ�õ�ǰϵͳĬ�ϵ��ַ������ж�д
		 */
		FileWriter writer = 
			new FileWriter("fw.txt");
		BufferedWriter bw =
			new BufferedWriter(writer);
		bw.write("��Һ�");
		bw.close();
	}
}
