package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo2 {
	public static void main(String[] args) throws IOException {
		//FileOutputStream fos = new FileOutputStream("fos.dat");
		/*
		 * FileOutputStream(String fileName,boolean append)
		 * 在当前文件上追加写操作
		 */
	
		FileOutputStream fos = new FileOutputStream("fos.dat",true);
		//当重新写入内容时，该文件原来内容全部被废弃
		fos.write('B');
		fos.close();

		
	}
}































