package day05;

public class Demo5 {
	public static void main(String[] args) {
		boolean b = hit(122,55,48,65,50);
		System.out.println(b);
	}
	public static boolean hit(int x1,int y1,int x,int y,int r){
		int dx = x1 - x;
		int dy = y1 - y;
		double d = Math.sqrt(dx*dx+dy*dy);
//		if(d<r){
//			return true;
//		}else{
//			return false;
//		}
		return d<=r;
	}
}
