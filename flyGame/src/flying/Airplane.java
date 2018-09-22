package flying;

import java.util.Random;

//�л�
public class Airplane extends FlyingObject implements Enemy{
	private int speed = 2;
	public Airplane(){
		//��ȡ�л���ͼƬ
		image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		//����λ��
		x = new Random().nextInt(ShootGame.WIDTH-width);
		y = -height;
	}
	//�л�����
	public boolean outOfBounds() {
		return this.y>ShootGame.HEIGHT;
	}

	public void step() {
		this.y += speed;
	}

	public int getScore() {  //��������
		return 5;
	}
	
}












