package day04;

import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input score:");
		int score = sc.nextInt();
		if(score<0 || score>100){
			System.out.println("input error!");
		}
		String level;
		switch(score/10){       //�жϱ��ʽ����ֵΪ����
			case 10:level="����";break; //case 10:�������ʡ��
			case 9:level="����";break;
			case 8:level="����";break;
			case 7:level="�е�";break;
			case 6:level="����";break;
			default:level="������";break;
		}
		System.out.println("��ĵȼ��ǣ� "+level);
	}
}
