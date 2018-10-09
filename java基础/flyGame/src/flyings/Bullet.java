package flyings;

public class Bullet extends FlyingObject{
	private int speed = 3;
	
	public Bullet(int x,int y) {
		image = ShootGame.bullet;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	public boolean outOfBounds() {
		return this.y<-height;
	}

	public void step() {
		this.y -= speed;
	}

}
