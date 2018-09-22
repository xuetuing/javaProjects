package day03;

import java.math.BigDecimal;

public class BigDecmalDemo {
	public static void main(String[] args) {
		//BigDecimal d1 = new BigDecimal("3.0");
		BigDecimal d1 = BigDecimal.valueOf(3.0);
		BigDecimal d2 = BigDecimal.valueOf(2.9);
		
		BigDecimal d3 = d1.subtract(d2);
		d3 = d1.multiply(d2);
		/*
		 * 对除法而言，通常不是使用一个参数的方法
		 * 如果出现商为无限小数，会一直除到内存溢出
		 * 使用三个参数的方法：除数，保留小数位数，舍入模式
		 */
		//d3 = d1.divide(d2);
		d3 = d1.divide(d2,9,4);
		System.out.println(d3);
		
		
	}
}
