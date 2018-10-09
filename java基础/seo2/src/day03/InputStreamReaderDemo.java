package day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//字符输入流
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		/*
		 * int read()
		 * 读取一个字符，以int值的形式返回，该int值"低16位"有效
		 * 
		 * int read(char[] c)
		 * 一次最多尝试读取给定数组的length()个字符，并存入数组，
		 * 返回值为实际读取到的字符量
		 * 
		 * int read(char[] c,int start,int len)
		 * 将给定字符数组中从start处开始连续读取len个字符
		 */
		int c = -1;
		while((c=isr.read())!=-1){
			System.out.println((char)c);
		}
		isr.close();
	}
}
