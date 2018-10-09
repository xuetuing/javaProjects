package day04.FlyWar;

public class Bee extends FlyingObject implements enemy,Award{
	private double r;
	int award;
	public Bee() {}
	public Bee(int x,int y,double r) {
		super(x,y);
		this.r = r;
		//this.award = 0;
		this.award = Award.DOUBLE_FIRE;
	}

	@Override
	public boolean shootBy(int x, int y) {
		double dx = x - this.x;
		double dy = y - this.y;
		return Math.sqrt(dx*dx+dy*dy)<=r;
	}

	@Override
	public int getType() {		
		return award;
	}
	

}
