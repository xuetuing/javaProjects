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
		 * �Գ������ԣ�ͨ������ʹ��һ�������ķ���
		 * ���������Ϊ����С������һֱ�����ڴ����
		 * ʹ�����������ķ���������������С��λ��������ģʽ
		 */
		//d3 = d1.divide(d2);
		d3 = d1.divide(d2,9,4);
		System.out.println(d3);
		
		
	}
}
