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
			 * ��ȡ��ǰFile�������������ļ�����Ŀ¼�ĸ�Ŀ¼
			 */
			File dir = file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			file.createNewFile();	
		}
		System.out.println("�������");
		
	}
}
