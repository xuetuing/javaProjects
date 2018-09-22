package day04.shape;

public abstract class Shape {
	Point location;
	public abstract double area();
	public abstract boolean contains(int x,int y);
	public boolean contains(Point p){
		return this.contains(p.x,p.y);
	}
}
