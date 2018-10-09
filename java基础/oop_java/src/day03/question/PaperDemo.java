package day03.question;

import java.util.Scanner;

public class PaperDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Question[] q = new Question[2];
		String singletext= " 1+1=?";
		String[] singleop = {"A:1","B:2","C:5","D:7"};
		String[] multiop = {"A:y","B:Y","C:5","D:7"};
		String multitext = " panda是熊猫吗？";
		char[] answer = {'A','B'};
		q[0] = new SingleQuestion(1,singletext,singleop,'A');
		q[1] = new MultiQuestion(2,multitext,multiop,answer);
		String input;
		for(int i=0;i<q.length;i++){
			q[i].print();
			System.out.print("请输入答案：");
			//input = sc.next();
			input = sc.nextLine();
			if(q[i].check(input.toCharArray())){
				System.out.println("答案正确！");
			}else{
				System.out.println("答案错误！");
			}
		}
		
	}
}
