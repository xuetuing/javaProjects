package day04.FlyWar;

public class enemyFlying extends FlyingObject implements enemy{
	private double width;
	private double height;
	public enemyFlying(){}
	public enemyFlying(int x,int y,int width,int height){
		super(x,y);
		this.width = width;
		this.height = height;
	}
	@Override
	public boolean shootBy(int x, int y) {
		double dx = x - this.x;
		double dy = y - this.y;
		return dx>=0 && dx<=width && dy>=0 && dy<=height;
	}
}
