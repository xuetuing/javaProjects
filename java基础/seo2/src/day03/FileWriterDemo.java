package day03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//缓存字符输出流
public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * FileWriter(File file)
		 * FileWriter(String fileName)
		 * 可以直接对文件写字符，使用FW或者FR就默认许可了
		 * 使用当前系统默认的字符集进行读写
		 */
		FileWriter writer = 
			new FileWriter("fw.txt");
		BufferedWriter bw =
			new BufferedWriter(writer);
		bw.write("大家好");
		bw.close();
	}
}
