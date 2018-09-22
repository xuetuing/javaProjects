package day03;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class DataInputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("dos.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		//联合使用,DataInputStream以bis构建
		DataInputStream dis = new DataInputStream(bis);
		
		//DataInputStream dis = new DataInputStream(fis);
		//BufferedInputStream bis = new BufferedInputStream(dis);
		//高级流可以以低级流构建对象，高级流可以相互之间构建对象，实现功能联合使用
		
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		
		dis.close();
	}
}