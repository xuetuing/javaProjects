package day05;

public class Demo4 {
	public static void main(String[] args) {
		boolean b = hit(122,127,66,81,67,59);
		System.out.println(b);
	}
	public static int f(int x){
		return 3*x+5;
	}
	public static boolean hit(int x1,int y1,int x,int y,int w,int h){
		int dx = x1 - x;
		int dy = y1 - y;
		return dx>0 && dx<w && dy>0 && dy<h;
	}
	
}
