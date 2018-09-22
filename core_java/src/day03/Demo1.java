package day03;

import java.util.Random;

public class Demo1{
	public static void main(String[] args){
		Random rd = new Random();
		int n = rd.nextInt(10);
		char c = (char)('A' + n);
		System.out.println(c);	
	}
}