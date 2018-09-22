package flying;
//×Óµ¯
public class Bullet extends FlyingObject{
	private int speed = 3;
	
	public Bullet(int x,int y){
		//Ìí¼Ó×Óµ¯Í¼Æ¬
		image = ShootGame.bullet;
		this.x = x;
		this.y = y;
		width = image.getWidth();
		height = image.getHeight();
	}

	public boolean outOfBounds() {
		return y<-height;
	}

	public void step() {
		y -= speed;
	}
}
