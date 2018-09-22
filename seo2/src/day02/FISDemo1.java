package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

//文件字节输入流
public class FISDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * FileInputStream(File file)
		 * FileInputStream(String fileName)
		 */
		FileInputStream fis = new FileInputStream("fos.dat");
		/*
		 * int read()
		 * 读取一个字节，并以int的形式返回，"低8位"有效
		 * 若返回-1，说明EOF
		 */
		System.out.println((char)fis.read());
		//System.out.println(fis.read());
		
		/*
		 * int read(byte[] b)
		 * 一次性尝试读取给定的数组长度的字节量，并存入给定的数组中
		 * 返回值为实际读取到的字节量
		 */
		byte[] array = new byte[100];
		int len = fis.read(array);

		String str = new String(array,0,len,"UTF-8");
		System.out.println(len);
		System.out.println(str);
		//System.out.println(Arrays.toString(array));
		/*
		 * String(byte[] b,int start,int len,String csn)
		 */
		//String str = new String(array,"UTF-8");
//		String str = new String(array,0,len,"UTF-8");
//		System.out.println(str);
		/*
		 * int read(byte[] b,int start,int len)
		 * 从该流中最多读取len个字节并从给定字节数组的start处开始存入
		 */
		
		
		
		fis.close();
		
	}
}
































