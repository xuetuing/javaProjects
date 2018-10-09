package day01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * java.io.File
 * File类的每个实例用于描述一个文件或目录的信息
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		//使用绝对路径不可取，不易于跨平台操作
//		File file = new File("D:/Program Files/Workspaces/MyEclipse 8.6/seo2/test.txt");
		/*
		 * 使用相对路径
		 * "."表示当前目录，这里当前目录指的是当前程序所在项目的根目录
		 * 
		 * File的常量separator:表示目录的层级分隔符
		 * 在windows平台下，该常量的值为字符"\"
		 * 在Linux平台下，该常量值为"/"
		 */
		//File file = new File(".\\test.txt");
		File file = new File("."+File.separator+"test.txt");
		System.out.println(file.length());
		long lm = file.lastModified();
		System.out.println(lm);
		//yyyy年MM月dd日 HH时mm分ss秒
		Date date = new Date(lm);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		System.out.println(sdf.format(date));
		System.out.println(file.getName());
		System.out.println(file.getPath());
		//获取绝对路径
		System.out.println(file.getAbsolutePath());
		//获取系统标准的绝对路径（需要捕获异常）
		System.out.println(file.getCanonicalPath());
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
	}
}





















