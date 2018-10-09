package day04.FlyWar;

import java.util.Random;

public class pig extends FlyingObject implements Award{
	private double r;
	int award;
	public pig(){}
	public pig(int x,int y,double r) {
		super(x,y);
		this.r = r;
		//this.award = this.getType();
		award = new Random().nextInt(2);
	}
	@Override
	public int getType() {		
		//return (new Random().nextInt(2));
		return award;
	}
	
}
