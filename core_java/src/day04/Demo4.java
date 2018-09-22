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
		switch(score/10){       //判断表达式返回值为整型
			case 10:level="优秀";break; //case 10:后边语句可省略
			case 9:level="优秀";break;
			case 8:level="良好";break;
			case 7:level="中等";break;
			case 6:level="及格";break;
			default:level="不及格";break;
		}
		System.out.println("你的等级是： "+level);
	}
}
