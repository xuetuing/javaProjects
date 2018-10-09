package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Ref;

//文件内容的写操作
public class RandomAccessFileDemo {
	public static void main(String[] args) throws InterruptedException, IOException{
		//之前创建过File对象，可以用此构造方法
//		File file = new File("raf.dat");
//		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		//之前没有创建过File对象，可以用此构造方法
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
		/*
		 * write(int d)
		 * 写入的是该int值的"低8位"
		 * 英文字母可以直接使用write()方法写出，一个字节可以描述
		 */
		//raf.wait(1000);
		raf.write('A');
		raf.write('B');
		//中文不行，中文要满两个字节
		//raf.write('中');
//		raf.seek(1);
//		System.out.println((char)raf.read());
//		raf.close();
		String str = "大家好";
		byte[] strDate = str.getBytes("UTF-8");
//		for(byte b : strDate){
//			raf.write(b);
//		}
		/*
		 * write(byte[] b)
		 * 将给定的字节数组中的所有字节一次性写出
		 */
		raf.write(strDate);
		//写int的最大值
		int max = Integer.MAX_VALUE;
		raf.write(max>>>24);
		raf.write(max>>>16);
		raf.write(max>>>8);
		raf.write(max);//低8位
		//writeInt(int d)  连续写4个字节，将给定的int 值直接写入
		raf.writeInt(100);
		raf.writeLong(100L);
		raf.writeChar('中');
		raf.writeDouble(12.34);
		
		raf.close();
	}
	
}


















