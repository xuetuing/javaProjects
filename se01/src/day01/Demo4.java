package day01;

public class Demo4 {
	public static void main(String[] args) {
		String s = " agojfo wfwo ";
		//System.out.println(s.charAt(2));
		
		String email = "15qq56qq53@qq.com";
		int i = email.indexOf('@');
//		System.out.println(i);
//		
//		i = email.indexOf("qq");
//		System.out.println(i);
//		
//		i = email.indexOf("qq",4);
//		System.out.println(i);
		
		//i = email.lastIndexOf('5',5);//���ص���������������õ��Ľ����������������ʼλ��
		i = email.lastIndexOf("qq",6);
		System.out.println(i);
		
		System.out.println(s.trim());
		
	}
}
