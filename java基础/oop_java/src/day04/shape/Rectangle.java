package day04.shape;

public class Rectangle extends Shape{
	private double width;
	private double height;
	public Rectangle(){}
	public Rectangle(int x,int y,double width,double height){
		this.location = new Point(x,y);
		this.width = width;
		this.height = height;
	}
	@Override
	public double area() {
		return width*height;
	}
	@Override
	public boolean contains(int x, int y) {
		double dx = x - this.location.x;
		double dy = y - this.location.y;
		return dx>=0 && dx<=width && dy>=0 && dy<=height;
	}
	
}
