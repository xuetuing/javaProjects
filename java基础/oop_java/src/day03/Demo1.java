package day03;

public class Demo1 {

}

class FlyingObject{
	int x;
	int y;
	public void moveTo(int x,int y){
		this.x = x;
		this.y = y;
	}
	public boolean shootBy(int x,int y){
		return false;
	}
	
}
class Airplane extends FlyingObject{
	int width;
	int height;
	public Airplane(int x,int y,int w,int h){
		this.x = x;
		super.y = y; //super.y = y;访问父类继承的属性y
		this.width = w;
		height = h;
		
	}
	public boolean shootBy(int x,int y){
		int dx = x - this.x;
		int dy = y - this.y;
		return dx>0&&dx<width&&dy>0&&dy<height;
	}
	public String toString(){
		return "飞机{"+x+","+y+","+width+","+height+"}";
	}
}

class Bee extends FlyingObject{
	double r;
	public Bee(int x,int y,double r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public boolean shootBy(int x,int y){
		int dx = x - this.x;
		int dy = y - this.y;
		return Math.sqrt(dx*dx+dy*dy)<=r;
	}
	public String toString(){
		return "小蜜蜂（"+x+","+y+","+r+"）";
	}
}






















































