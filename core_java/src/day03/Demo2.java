package day03;
public class Demo2 {
	public static void main(String[] args){
		long l = 5;
		long l1 = 5L;
		l = 8L;
		int x = (int)l;
		System.out.println(x);
		x = (int)l;
		double pi = Math.PI;
		float f = (float)pi;
		l = (long)pi;
		System.out.println(pi);
		System.out.println(f);
		System.out.println(l);
		//byte short char底层运算都是以int操作的
		byte b1 = 2;
		byte b2 = 2;
		byte b3 = (byte)(b1 + b2); //此操作是以int类型计算的
		char c = 'A' + 1; //编译期优化
		char ch = 'A';
		c = (char)(ch + 1);
		System.out.println(c);
	}
}
