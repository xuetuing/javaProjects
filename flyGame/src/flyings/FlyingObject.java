package flyings;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected BufferedImage image;
	
	public abstract void step();
	
	public abstract boolean outOfBounds();
	
	public boolean shootBy(Bullet b){
		int dx = b.x - this.x;
		int dy = b.y - this.y;
		return dx>0 && dx<width && dy>0 && dy<height;
	}
	
}
