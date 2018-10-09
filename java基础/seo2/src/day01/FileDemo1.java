package day01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * java.io.File
 * File���ÿ��ʵ����������һ���ļ���Ŀ¼����Ϣ
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		//ʹ�þ���·������ȡ�������ڿ�ƽ̨����
//		File file = new File("D:/Program Files/Workspaces/MyEclipse 8.6/seo2/test.txt");
		/*
		 * ʹ�����·��
		 * "."��ʾ��ǰĿ¼�����ﵱǰĿ¼ָ���ǵ�ǰ����������Ŀ�ĸ�Ŀ¼
		 * 
		 * File�ĳ���separator:��ʾĿ¼�Ĳ㼶�ָ���
		 * ��windowsƽ̨�£��ó�����ֵΪ�ַ�"\"
		 * ��Linuxƽ̨�£��ó���ֵΪ"/"
		 */
		//File file = new File(".\\test.txt");
		File file = new File("."+File.separator+"test.txt");
		System.out.println(file.length());
		long lm = file.lastModified();
		System.out.println(lm);
		//yyyy��MM��dd�� HHʱmm��ss��
		Date date = new Date(lm);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		System.out.println(sdf.format(date));
		System.out.println(file.getName());
		System.out.println(file.getPath());
		//��ȡ����·��
		System.out.println(file.getAbsolutePath());
		//��ȡϵͳ��׼�ľ���·������Ҫ�����쳣��
		System.out.println(file.getCanonicalPath());
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
	}
}





















