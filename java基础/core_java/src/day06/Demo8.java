package day06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入购买的组数：");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++){
			String[] balls = gen();
			System.out.println(Arrays.toString(balls));
		}
	}
	public static String[] gen(){
		String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				 "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"};
		 //String[] pool1 = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16"};
		 boolean[] judge = new boolean[pool.length];  //匹配标签
		 String[] balls = new String[6];
		 int count = 0;
		 Random rd = new Random();
		 do{
			 int index = rd.nextInt(pool.length);
			 if(judge[index]){
				 continue;
			 }
			 balls[count] = pool[index]; //balls[count++] = pool[index];
			 judge[index] = true;
			 count++;
		 }while(count!=6);
		 int index = rd.nextInt(16);
		 //String blue = String.valueOf(rd.nextInt(16)+1);
		 //balls = Arrays.copyOf(balls,balls.length+1);
		 balls[balls.length-1] = pool[index];
		 //balls[balls.length-1] = blue;
		 Arrays.sort(balls);
		 return balls;
	}
}
