package flyings;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index = 0;
	public Hero(){
		image = ShootGame.hero0;
		this.x = 151;
		this.y = 450;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.life = 3;
		this.doubleFire = 0;
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		
	}

	@Override
	public boolean outOfBounds() {
		return false;
	}
	@Override
	public void step() {
		image = index++ % 20 ==0?images[0]:images[1];
	}
	public void moveTo(int x,int y){
		this.x = x - width/2;
		this.y = y - height/2;
	}
	public void addLife(){
		this.life++;
	}
	public int getLife(){
		return this.life;
	}
	public void subtractLife(){
		this.life--;
	}
	//发射子弹,返回构造好的子弹
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
		this.doubleFire++;
	}
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	public boolean hit(FlyingObject obj){
		int heroX = this.x + this.width;
		int heroY = this.y + this.height;
		int x1 = obj.x - this.width/2;
		int x2 = obj.x + obj.width + this.width/2;
		int y1 = obj.y - this.height/2;
		int y2 = obj.y + obj.height + this.height/2;
		return heroX>x1 && heroX<x2 && heroY>y1 && heroY<y2;
	}
	
}








