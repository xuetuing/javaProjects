package flying;

import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private int awardType;
	private int xspeed = 1;
	private int yspeed = 2;
	public Bee(){
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		//出现位置
		Random rd = new Random();
		x = rd.nextInt(ShootGame.WIDTH-width);
		y = -height;
		awardType = rd.nextInt(2);
	}
	public boolean outOfBounds() {
		return this.y>ShootGame.HEIGHT;
	}

	public void step() {
		this.x += xspeed;
		this.y += yspeed;
		
		if(this.x > ShootGame.WIDTH-width)
			xspeed = -1;    //更改速度实现反弹
		if(this.x < 0)
			xspeed = 1;
	}

	public int getType() {
		return awardType;
	}
}








