package day03;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class DataInputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("dos.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		//����ʹ��,DataInputStream��bis����
		DataInputStream dis = new DataInputStream(bis);
		
		//DataInputStream dis = new DataInputStream(fis);
		//BufferedInputStream bis = new BufferedInputStream(dis);
		//�߼��������Եͼ����������󣬸߼��������໥֮�乹������ʵ�ֹ�������ʹ��
		
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		
		dis.close();
	}
}