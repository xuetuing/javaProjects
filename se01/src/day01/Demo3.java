package day01;

public class Demo3 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1==s2);//true被优化为同一个字符串,在常量池
		
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s3==s4);//false两个对象，在堆中，地址值不同
		
		String s5 = s3.concat("");
		//String s5 = s3.concat(" ");
		System.out.println(s3==s5);//true内容不变则为true,否则false
		
	}
}
