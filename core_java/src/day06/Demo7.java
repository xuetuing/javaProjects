package day06;

import java.util.Arrays;
import java.util.Random;
//String.valueOf(value) 将数字转换成字符串
public class Demo7 {
	public static void main(String[] args) {
		//String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
		//		 "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"};
		 //String[] pool1 = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16"};
		 boolean[] judge = new boolean[33];
		 String[] num = new String[6];
		 int count = 0;
		 String tmp;
		 Random rd = new Random();
		 while(true){			 
			 int index = rd.nextInt(33)+1;
			 if(count==6){
				 break;
			 }
			 if(judge[index]==true){
				 continue;
			 }
			 if(index<10){
				 tmp = "0" + String.valueOf(index);
			 }else{
				 tmp = String.valueOf(index);
			 }
			 num[count] = tmp; 
			 judge[index] = true;
			 count++;
		 }
		 //int index = rd.nextInt(16)+1;
		 String blue = String.valueOf(rd.nextInt(16)+1);
		 num = Arrays.copyOf(num,num.length+1);
		 //num[num.length-1] = pool1[index];
		 num[num.length-1] = blue;
		 Arrays.sort(num);
		 System.out.println(Arrays.toString(num));
	}
}
