package day02;

public class Circle {
	Point center;
	double r;
	public Circle(){}
	public Circle(Point center,double r){
		this.center = center;
		this.r = r;
	}
	public double area(){
		return Math.PI*r*r;
	}
	public void contains(int x,int y){
		if(this.center.distance(x, y)<=this.r){
			System.out.println("在圆内！");
		}else{
			System.out.println("在圆外！");
		}
	}
	//public boolean contains(int x,int y){}
	public void contains(Point p){
		if(this.center.distance(p)<=this.r){
			System.out.println("在圆内！");
		}else{
			System.out.println("在圆外！");
		}
	}
	
}
