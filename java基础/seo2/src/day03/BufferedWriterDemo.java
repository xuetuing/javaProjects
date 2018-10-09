package day03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//缓存字符输出流
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bw.txt",true);
		
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		/*
		 * BufferedWriter(Writer writer)
		 * 将给定的字符输出流转换为缓存字符输出流
		 */
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("你好");
		bw.close();
	}
}
