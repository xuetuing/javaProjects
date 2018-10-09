package testdemo.file;

import java.util.Arrays;


public class Test {
	
	public static void main(String[] args) throws Exception {
		String str = "ÄãºÃ ABC"; 
		
		System.out.println(str.getBytes("GBK").length);
		System.out.println(Utils.substrs1(str,7,"GBK"));
		System.out.println(Arrays.toString(str.getBytes("GBK")));
		
	}

}
