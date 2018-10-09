package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//使用缓存字符输入输出流复制文本文件
public class CopyDemo2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis =
			new FileInputStream("src"+File.separator+
					"day03"+File.separator+
					"CopyDemo2.java");
		InputStreamReader isr =
			new InputStreamReader(fis);
		BufferedReader br = 
			new BufferedReader(isr);
		
		FileOutputStream fos =
			new FileOutputStream("CopyDemo2.java");
		OutputStreamWriter osw =
			new OutputStreamWriter(fos);
		BufferedWriter bw =
			new BufferedWriter(osw);
		
		String line = null;
		while((line=br.readLine())!=null){
			bw.write(line);
			/*
			 * void newLine()
			 * 输出一个当前系统支持的换行符
			 */
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}
