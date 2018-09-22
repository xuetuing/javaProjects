package day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//使用字符流复制文本文件
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		//拷贝当前程序的源代码到项目的根目录
		FileInputStream fis =
			new FileInputStream("src"+File.separator+
					"day03"+File.separator+
					"CopyDemo1.java");
		FileOutputStream fos =
			new FileOutputStream("CopyDemo1.java");
		InputStreamReader isr =
			new InputStreamReader(fis);
		OutputStreamWriter osw =
			new OutputStreamWriter(fos);
		int c = -1;
		while((c=isr.read())!=-1){
			osw.write(c);
		}
		System.out.println("复制完毕");
		isr.close();
		osw.close();
	}
}
