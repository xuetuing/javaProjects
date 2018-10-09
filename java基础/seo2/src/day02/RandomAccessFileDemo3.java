package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf2.dat","rw");
		//long getFilePointer()	返回游标当前位置
		System.out.println(raf.getFilePointer());
		/*
		 * 将一个int值转换为字节后写入文件
		 * 1.将int值转换为4个字节-->将数据转换为对应字节序列的过程：序列化
		 * 2.将4个字节写入磁盘-->将字节序列写入磁盘长久保存的过程：持久化
		 * 
		 */
		raf.writeInt(100);
		System.out.println(raf.getFilePointer());
		/*
		 * RandomAccessFile的读写操作时基于游标指向的当前位置进行的
		 * 所以在写完数据后，想从头读取数据，要将游标置0;
		 */
		raf.seek(0);
		//将字节序列转换为对应的数据的过程：反序列化
		System.out.println(raf.readInt());
		//读写字符串
		String str = "我是一个字符串";//写的时候一对引号占两个字节
		raf.writeUTF(str);
		raf.seek(4);
		System.out.println(raf.readUTF());//读的时候双引号不显示
		raf.close();
		
		
	}
}
























