package testdemo.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Utils {
	public static void copyFile(File source,File dest) throws Exception{
		//输入流
		FileInputStream fis = new FileInputStream(source);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		//输出流
		FileOutputStream fos = new FileOutputStream(dest);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		byte[] buf = new byte[1024];
		while((bis.read(buf))!=-1){
			bos.write(buf);
			bos.flush();
		}
		
		bis.close();
		bos.close();
	}
	
	public static String substrs(String s,int bts) throws Exception{
		byte[] arr = s.getBytes("GBK");
		boolean isChineseHalf = false;  //遇到汉字循环2次 +1
		int off = 0;
		for(int i=0;i<bts;i++){
			if(arr[i]<0 && !isChineseHalf){
				isChineseHalf = true;
			}else{
				off++;
				isChineseHalf = false;
			}
		}
		String str = s.substring(0,off);
		return str;
	}
	public static String substrs1(String s,int bts,String charset) throws Exception{
		int step = 0;
		if(charset.equals("UTF-8")){   //此处匹配应用正则匹配多种情况
			step = 3;
		}else if(charset.equals("GBK")){
			step = 2;
		}
		byte[] arr = s.getBytes(charset);
		int off = 0;
		for(int i=0;i<bts;){
			if(arr[i]<0){
				off++;
				i += step;
			}else{
				off++;
				i++;
			}
		}
		String str = s.substring(0,off);
		return str;
	}
}










