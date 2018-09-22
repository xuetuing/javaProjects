package day04.shape;

public class Circle extends Shape{
	private double r;
	public Circle(){}
	public Circle(int x,int y,double r){
		this.location = new Point(x,y);
		this.r = r;
	}
	@Override
	public double area() {
		return Math.PI*r*r;
	}

	@Override
	public boolean contains(int x, int y) {
		return this.location.distance(x, y)<=r;
	}
	
}
