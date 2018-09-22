package day03;

import java.math.BigInteger;

public class BigIntegerDemo {
	public static void main(String[] args) {
		//¼ÆËã200µÄ½×³Ë
//		long sum = 1;
//		for(int i =1;i<=200;i++){
//			sum *= i;
//		}
//		System.out.println(sum);
		
		//add() subtract() multiply() divide()
		BigInteger sum = BigInteger.valueOf(1);
		for(int i =1;i<=10000;i++){
			//sum = sum.multiply(BigInteger.valueOf(i));
			sum = sum.add(BigInteger.valueOf(i));
		}
		System.out.println(sum);
		
		
	}
}
