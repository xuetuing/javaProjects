package flying;

import java.awt.image.BufferedImage;

//Ӣ�ۻ�
public class Hero extends FlyingObject{
	private int doubleFire;
	private int life;
	private BufferedImage[] images = {};
	private int index;
	
	public Hero(){
		image = ShootGame.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 151;
		y = 450;
		doubleFire = 0;
		life = 3;
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
	}
	//�жϳ��磨û�У�
	public boolean outOfBounds() {
		return false;
	}
	//��Ϊ����ͼƬ�ı任
	public void step() {
		int num = index++/10 % images.length; //ʵ����0��1֮��任�����ҽ�Ƶ
		image = images[num];
	}
	//�����ӵ��ķ�ʽ
	public Bullet[] shoot(){
		int xstep = this.width/4;
		int ystep = 20;
		if(doubleFire>0){
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x+1*xstep,this.y-ystep);
			bullets[1] = new Bullet(this.x+3*xstep,this.y-ystep);
			return bullets;
		}else{
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x+2*xstep,this.y-ystep);
			return bullets;
		}
		
	}
	public void addDoubleFire(){
		doubleFire++;
	}
	//���û���
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	//�ƶ�Ӣ�ۻ��ķ���
	public void moveTo(int x,int y){
		this.x = x - width/2;
		this.y = y - height/2;
	}
	//������
	public void addLife(){
		life++;
	}
	//��ȡ��
	public int getLife(){
		return life;
	}
	//����
	public void subtractLife(){
		life--;
	}
	//�ж�Ӣ�ۻ��Ƿ�����˷�����ײ
	public boolean hit(FlyingObject flying){
		int heroX = this.x+width/2;
		int heroY = this.y+height/2;
		int dx1 = flying.x - this.width/2;
		int dx2 = flying.x + flying.width + this.width/2;
		int dy1 = flying.y - this.height/2;
		int dy2 = flying.height+flying.y+this.height/2;
//		this.x+width/2 > flying.x - width/2;
//		this.x+width/2 < flying.x + flying.width + this.width;
//		
//		this.y+height/2 > flying.y - height/2
//		this.y+height/2 < flying.height+flying.y+height/2
		return heroX>dx1 && heroX<dx2 && heroY>dy1 && heroY<dy2;
			
	}
	
}





















