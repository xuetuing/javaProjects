package day04;

import java.util.Scanner;

public class Demo9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score;
		do{
			System.out.print("���������");
			score = sc.nextInt();
		}while(score<0 || score>100);
		System.out.println("��ķ����ǣ�"+score);
	}
}
