package day03;

public class Demo9 {
	public static void main(String [] args){
		int a = 5;
		int b = 4;
		int c = a + b;
//		System.out.println(c);
		String s = "5" + 5;  //字符串连接
//		System.out.println(s);
		System.out.println(1+2+"ABC");
		System.out.println(1+'2'+"ABC"); //char 类型以int类型计算，只要有String类型，就会发生连接
		System.out.println('1'+2+3+"ABC");//考虑运算顺序，从左到右，左侧int型会发生整型运算，而String在最左侧时，只发生连接
		System.out.println("ABC"+1+2);//并且String 在前时，'+'发生的全部为连接
	}
}
