package day06;

import java.util.Arrays;
import java.util.Random;

//Ë«É«ÇòËæ»úÂòºÅ

public class Demo6 {
	public static void main(String[] args) {
		 String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				 "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"};
		 //String[] pool1 = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16"};
		 boolean[] judge = new boolean[pool.length];  //Æ¥Åä±êÇ©
		 String[] balls = new String[6];
		 int count = 0;
		 Random rd = new Random();
		 while(true){			 
			 int index = rd.nextInt(pool.length);
			 if(count==6){
				 break;
			 }
			 if(judge[index]){
				 continue;
			 }
			 balls[count] = pool[index]; //balls[count++] = pool[index];
			 judge[index] = true;
			 count++;
		 }
		 //int index = rd.nextInt(16)+1;
		 String blue = String.valueOf(rd.nextInt(16)+1);
		 balls = Arrays.copyOf(balls,balls.length+1);
		 //num[num.length-1] = pool1[index];
		 balls[balls.length-1] = blue;
		 Arrays.sort(balls);
		 System.out.println(Arrays.toString(balls));
	}
}
