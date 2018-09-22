package day02;

public class PointDemo {
	public static void main(String[] args){
		Point p1 = new Point();
		p1.x = 3;
		p1.y = 4;
		System.out.println(p1.x+","+p1.y);
		Point p2 = new Point(5,4);
		System.out.println(p2.x+","+p2.y);
		//Point p3 = new Point(3);
		//System.out.println(p3.x+","+p3.y);
	}
}
