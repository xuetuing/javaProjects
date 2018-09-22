package day03;

public class Demo8 {
	public static void main(String [] args){
		int num = 63785;
		int last = num % 10;
		num /= 10;
		System.out.print(last);
		last = num % 10;
		num /= 10;
		System.out.print(last);
		last = num % 10;
		num /= 10;
		System.out.print(last);
		last = num % 10;
		num /= 10;
		System.out.print(last);
		last = num % 10;	
		System.out.print(last);
	}
}
