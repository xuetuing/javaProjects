package flyings;

import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private int xspeed = 1;
	private int yspeed = 2;
	private int type;
	
	public Bee(){
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		this.x = new Random().nextInt(ShootGame.WIDTH - width);
		this.y = -height;
		this.type = new Random().nextInt(2);
	}

	@Override
	public boolean outOfBounds() {
		return this.y>ShootGame.HEIGHT;
	}

	@Override
	public void step() {
		this.x += xspeed;
		this.y += yspeed;
//		if(this.x <= 0)
//			this.x += xspeed;
//		if(this.x >= ShootGame.WIDTH-width)
//			this.x -= xspeed;
//		this.x += xspeed;
		if(this.x >= ShootGame.WIDTH-width)
			xspeed = -1;
		if(this.x <= 0)
			xspeed = 1;
	}

	@Override
	public int getType() {
		return type;
	}
	
}
