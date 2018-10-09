package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo2 {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try{
			raf = new RandomAccessFile("raf.dat","r");  //抛异常
			/*
			 * int read()
			 * 从文件中读取一个字节，并以int值的形式返回
			 * 该int 值只有低8位有效，若返回-1，说明EOF
			 * ＥＯＦ：end of file 文件读取到末尾
			 */
			System.out.println((char)raf.read());
			System.out.println((char)raf.read());
			byte[] strDate = new byte[9];
			/*
			 * int read(byte[] b)
			 * 一次性尝试读取给定字节数组长度的字节，并
			 * 存入到给定的字节数组中，返回值为实际读取到的字节量
			 */
			raf.read(strDate);
			String str = new String(strDate,"UTF-8");//String	构造方法
			System.out.println(str);
			/*
			 * int readInt()
			 * 一次读取4个字节，拼接为int
			 */
			System.out.println(raf.readInt());
			System.out.println(raf.readInt());
			System.out.println(raf.readLong());
			System.out.println(raf.readChar());
			System.out.println(raf.readDouble());
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(raf!=null){
					raf.close();	//抛异常
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
}
