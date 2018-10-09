package day01;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
//		Object b = new String("abc");
//		System.out.println(b.toString());
//		System.out.println(b instanceof String);
		
		char[] chs1 = {'南','京'};
		char[] chs2 = {'学','码','思'};
		char[] chs3 = new char[5];
		System.arraycopy(chs1, 0, chs3, 0, 2);
		System.arraycopy(chs2, 0, chs3, 2, 3);
		System.out.println(chs3);
		
		char[] chs4 = Arrays.copyOf(chs1, chs1.length+3);
		System.out.println(chs4);
		System.arraycopy(chs2, 0, chs4, 2, 3);
		System.out.println(chs3);
		System.out.println(chs4);
		
		String s1 = "南京";
		String s2 = "学码思";
		String s3 = s1.concat(s2);
		System.out.println(s3);
		System.out.println(s2.concat(s1));
	}
}






































