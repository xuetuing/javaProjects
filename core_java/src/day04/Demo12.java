package day04;

import java.util.Random;
import java.util.Scanner;

public class Demo12 {
	public static void main(String[] args) {
		//猜数字游戏
		//第一，数据分析（理清楚业务规则）
		/*
		 * num   猜测的数字
		 * answer  用户猜测的答案
		 * count   猜测的次数
		 * 1.生成随机数num[1~100]
		 * 2.提示用户开始猜测
		 * 3.得到猜测的答案anwser
		 * 4.比较answer和num
		 *   计数count++
		 *   如果相等break
		 *   如果不相等，提示猜大了/猜小了
		 *   返回第2步
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int answer;
		int count=0;
		int num = rd.nextInt(100)+1;
		System.out.println("猜测数字：");
		while(true){
			answer = sc.nextInt();
			count++;
			if(answer == num){
				System.out.println("猜测正确："+num+","+"猜了"+count+"次");
				break;
			}else if(answer>num){
				System.out.println("猜大了！");
				System.out.print("继续猜测数字：");
			}else{
				System.out.println("猜小了！");
				System.out.print("继续猜测数字：");
			}
			//count++;
		}
		//System.out.println("猜测次数："+count);
	}
}
