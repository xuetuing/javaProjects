package day04;
/*
 * �������ڲ���Comparable�ӿ�
 * ʹ������пɱȽ���,��Ҫʵ��Comparable�ӿ�
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
	 * ��Ȼ���Ǳ���ģ����ǵ�equals()�����ıȽ�Ϊtrueʱ��
	 * comparaTo()ҲӦ�÷���0
	 */
	public int compareTo(Point1 o) {
		return x - o.x;
	}
	
}

















