package flying;

import java.util.Random;

//敌机
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;
	public Airplane(){
		//获取敌机的图片
		image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		//出现位置
		x = new Random().nextInt(ShootGame.WIDTH-width);
		y = -height;
	}
	//敌机出界
	public boolean outOfBounds() {
		return this.y>ShootGame.HEIGHT;
	}

	public void step() {
		this.y += speed;
	}

	public int getScore() {  //给个分数
		return 5;
	}
	
}












