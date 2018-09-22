package day02;
public class Cell{  //格子类
	int row;
	int col;
	//让格子下落的方法
	public void drop(){
		row++;   //算法
	}
	public void drop(int step){
		int row = 8;   //局部变量
		this.row += step;  //this.row是实例变量，this是局部变量
		this.drop();  //相互重用
	}
	public void moveRight(){
		col++;
	}
	public void moveRige(int step){
		col += step;
	}
}












