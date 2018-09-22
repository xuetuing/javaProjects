package day04.shape;

public class Point {
	int x;
	int y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	public double distance(){
		return Math.sqrt(x*x+y*y);
	}
	public double distance(int x,int y){
		double dx = x - this.x;
		double dy = y - this.y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	public double distance(Point p){
//		double dx = p.x - this.x;
//		double dy = p.y - this.y;
//		return Math.sqrt(dx*dx+dy*dy);
		return this.distance(p.x, p.y);  //尽量使用重用，使代码简洁
	}
	
}
