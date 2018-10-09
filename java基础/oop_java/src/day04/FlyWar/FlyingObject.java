package day04.FlyWar;

public class FlyingObject {
	int x;
	int y;
	int row=0;
	int col;
	
	public FlyingObject() {}

	public FlyingObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveTo(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}
