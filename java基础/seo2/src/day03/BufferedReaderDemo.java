package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =
			new FileInputStream("bw.txt");
		InputStreamReader isr =
			new InputStreamReader(fis,"UTF-8");
//		FileReader fr = new FileReader("bw.txt");
		BufferedReader br = 
			new BufferedReader(isr);
//			new BufferedReader(fr);
		/*
		 * String readLine()
		 * 一次读取一行字符串
		 * 连续读取若干个字符，直到读到换行符为止，
		 * 返回的字符串中不包含换行符
		 */
		String str = br.readLine();
		System.out.println(str);
		//缓存字符输入流readLine()方法若返回null,则说明EOF
		str = br.readLine();
		System.out.println(str);
		br.close();
	}
}
