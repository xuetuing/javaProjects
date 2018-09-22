package day02;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		System.out.println(dir.getCanonicalPath());
		if(dir.isDirectory()){
			/*
			 * String[] list()
			 * ��ȡ��ǰĿ¼�µ����е���������
			 */
			String[] subNames = dir.list();
			for(String sub : subNames){
				System.out.println(sub);
			}
			/*
			 * File[] listFiles()
			 * ��ȡ��ǰĿ¼�����е�����
			 */
			File[] subs = dir.listFiles();
			for(File sub : subs){
				System.out.println(sub.isFile()?"�ļ�":"Ŀ¼");
				System.out.println(sub.getName());
				System.out.println(sub.length());
				System.out.println();
			}
			
		}
	}
}






