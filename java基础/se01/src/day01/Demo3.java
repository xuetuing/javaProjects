package day01;

public class Demo3 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1==s2);//true���Ż�Ϊͬһ���ַ���,�ڳ�����
		
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s3==s4);//false���������ڶ��У���ֵַ��ͬ
		
		String s5 = s3.concat("");
		//String s5 = s3.concat(" ");
		System.out.println(s3==s5);//true���ݲ�����Ϊtrue,����false
		
	}
}
