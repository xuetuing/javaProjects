package day04;
/*
 * 该类用于测试Comparable接口
 * 使该类具有可比较性,需要实现Comparable接口
 */
public class Point1 implements Comparable<Point1>{
	private int x;
	private int y;
	public Point1(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	@Override
//	public int compareTo(Point1 o) {
//		int len = x*x + y*y;
//		int olen = o.x*o.x + o.y*o.y;
//		return len - olen;
//	}
	/*
	 * 虽然不是必须的，但是当equals()方法的比较为true时，
	 * comparaTo()也应该返回0
	 */
	public int compareTo(Point1 o) {
		return x - o.x;
	}
	
}

















