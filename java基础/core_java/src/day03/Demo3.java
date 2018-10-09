package day03;

public class Demo3 {
	public static void main(String [] args){
		int x = 5;
		int y = 3;
		int z = x + y;
		//System.out.println(z);
		long l = x + y; //int -> long -> =l
		l = 5L + y; //int -> long ->long add -> = l
//		//System.out.println(l);
//		l = Integer.MAX_VALUE +1;
//		//System.out.println(l);
//		l = Integer.MAX_VALUE +1L;
//		System.out.println(l);
//		System.out.println(Integer.MIN_VALUE);
//		l = Integer.MIN_VALUE -1;
//		System.out.println(l);
		int a = 1;
//		a = a++ + a + ++a - a++ + --a + a-- - a + a++ + ++a + a-- - a-- + a + a++
//		     1    2    3    3      3    3     2    2     4     4     3    2    2
//- a-- + a + ++a;
//		  3     2    3
		System.out.println(a);
		
	}

}
