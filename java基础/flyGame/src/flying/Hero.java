package flying;

import java.awt.image.BufferedImage;

//英雄机
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
	//判断出界（没有）
	public boolean outOfBounds() {
		return false;
	}
	//作为两张图片的变换
	public void step() {
		int num = index++/10 % images.length; //实现在0和1之间变换，并且降频
		image = images[num];
	}
	//发射子弹的方式
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
	//设置火力
	public void setDoubleFire(int doubleFire){
		this.doubleFire = doubleFire;
	}
	//移动英雄机的方法
	public void moveTo(int x,int y){
		this.x = x - width/2;
		this.y = y - height/2;
	}
	//增加命
	public void addLife(){
		life++;
	}
	//获取命
	public int getLife(){
		return life;
	}
	//减命
	public void subtractLife(){
		life--;
	}
	//判断英雄机是否与敌人发生碰撞
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





















