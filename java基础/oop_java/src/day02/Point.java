package day02;

public class Point{
	int x;
	int y;
	public Point(){}
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
//	public Point(int n){
//		this(n,n);
//		this.x = n;
//		this.y = n;
//	}
	public double distance(){
		return Math.sqrt(x*x+y*y);
	}
	public double distance(int x,int y){  //两点之间的距离
		return Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
	}
	public double distance(Point p){
		//return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
		return this.distance(p.x, p.y);
	}

}
