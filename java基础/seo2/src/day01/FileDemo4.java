package day01;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		File file = new File("g"+File.separator+
				"h"+File.separator+
				"i"+File.separator+
				"j"+File.separator+
				"mm.txt");
		if(!file.exists()){
			/*
			 * File getParentFile()
			 * 获取当前File对象所描述的文件或者目录的父目录
			 */
			File dir = file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			file.createNewFile();	
		}
		System.out.println("创建完毕");
		
	}
}
