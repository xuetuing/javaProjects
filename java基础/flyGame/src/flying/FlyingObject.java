package flying;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected BufferedImage image;//定义图片属性
	//飞行物运动方式
	public abstract void step();
	//判断飞行物是否出界
	public abstract boolean outOfBounds();
	//飞行物被击中的方法
	public boolean shootBy(Bullet b){
		int dx = b.x - this.x;
		int dy = b.y - this.y;
		return dx>0 && dx<width && dy>0 && dy<height;
	}
}
