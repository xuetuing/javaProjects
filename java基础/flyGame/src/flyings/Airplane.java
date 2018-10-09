package flyings;

import java.util.Random;

public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;
	private int score = 5;
	public Airplane(){
		image = ShootGame.airplane;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.x = new Random().nextInt(ShootGame.WIDTH-width);
		this.y = -height;
	}

	@Override
	public boolean outOfBounds() {
		if(this.y>=ShootGame.HEIGHT)
			return true;
		return false;
	}

	@Override
	public void step() {
		this.y += speed;
	}
	
	public int getScore(){
		return score;
	}
}
