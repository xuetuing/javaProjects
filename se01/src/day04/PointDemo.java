package day04;

public class PointDemo {
	public static void main(String[] args) {
		Point<Integer,Integer> p = new Point<Integer,Integer>(1,2);
		int x = p.getX();
		System.out.println(x);
		
//		Point pp = p;  //Point<Integer,Integer> pp = p;
//		pp.setX("1"); //pp���÷���ʱʱObject,���п��Խ���"1"
//		x = p.getX();
//		System.out.println(x);
		
		
	}
}
