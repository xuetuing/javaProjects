package day02;

import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input your id:");
		String regx = "^(\\d{15}|\\d{17}(\\d|X))$";
		String regx1 = "^\\d{15}(\\d{2}[0-9X])?$";
		String id;
//		do{
//			System.out.println("����������������룺");
//			id = sc.next();
//		}while(!id.matches(regx));
		id = sc.next();
		while(!id.matches(regx)){
			System.out.println("����������������룺");
			id = sc.next();
		}
		System.out.println("���id��"+id);
	
	}
}
