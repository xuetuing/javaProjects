package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Ref;

//�ļ����ݵ�д����
public class RandomAccessFileDemo {
	public static void main(String[] args) throws InterruptedException, IOException{
		//֮ǰ������File���󣬿����ô˹��췽��
//		File file = new File("raf.dat");
//		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		//֮ǰû�д�����File���󣬿����ô˹��췽��
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
		/*
		 * write(int d)
		 * д����Ǹ�intֵ��"��8λ"
		 * Ӣ����ĸ����ֱ��ʹ��write()����д����һ���ֽڿ�������
		 */
		//raf.wait(1000);
		raf.write('A');
		raf.write('B');
		//���Ĳ��У�����Ҫ�������ֽ�
		//raf.write('��');
//		raf.seek(1);
//		System.out.println((char)raf.read());
//		raf.close();
		String str = "��Һ�";
		byte[] strDate = str.getBytes("UTF-8");
//		for(byte b : strDate){
//			raf.write(b);
//		}
		/*
		 * write(byte[] b)
		 * ���������ֽ������е������ֽ�һ����д��
		 */
		raf.write(strDate);
		//дint�����ֵ
		int max = Integer.MAX_VALUE;
		raf.write(max>>>24);
		raf.write(max>>>16);
		raf.write(max>>>8);
		raf.write(max);//��8λ
		//writeInt(int d)  ����д4���ֽڣ���������int ֱֵ��д��
		raf.writeInt(100);
		raf.writeLong(100L);
		raf.writeChar('��');
		raf.writeDouble(12.34);
		
		raf.close();
	}
	
}


















