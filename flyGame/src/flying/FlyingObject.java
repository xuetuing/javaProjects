package flying;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected BufferedImage image;//����ͼƬ����
	//�������˶���ʽ
	public abstract void step();
	//�жϷ������Ƿ����
	public abstract boolean outOfBounds();
	//�����ﱻ���еķ���
	public boolean shootBy(Bullet b){
		int dx = b.x - this.x;
		int dy = b.y - this.y;
		return dx>0 && dx<width && dy>0 && dy<height;
	}
}
