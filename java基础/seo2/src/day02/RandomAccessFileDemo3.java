package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf2.dat","rw");
		//long getFilePointer()	�����α굱ǰλ��
		System.out.println(raf.getFilePointer());
		/*
		 * ��һ��intֵת��Ϊ�ֽں�д���ļ�
		 * 1.��intֵת��Ϊ4���ֽ�-->������ת��Ϊ��Ӧ�ֽ����еĹ��̣����л�
		 * 2.��4���ֽ�д�����-->���ֽ�����д����̳��ñ���Ĺ��̣��־û�
		 * 
		 */
		raf.writeInt(100);
		System.out.println(raf.getFilePointer());
		/*
		 * RandomAccessFile�Ķ�д����ʱ�����α�ָ��ĵ�ǰλ�ý��е�
		 * ������д�����ݺ����ͷ��ȡ���ݣ�Ҫ���α���0;
		 */
		raf.seek(0);
		//���ֽ�����ת��Ϊ��Ӧ�����ݵĹ��̣������л�
		System.out.println(raf.readInt());
		//��д�ַ���
		String str = "����һ���ַ���";//д��ʱ��һ������ռ�����ֽ�
		raf.writeUTF(str);
		raf.seek(4);
		System.out.println(raf.readUTF());//����ʱ��˫���Ų���ʾ
		raf.close();
		
		
	}
}
























