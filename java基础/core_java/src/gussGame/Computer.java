package gussGame;

import java.util.Random;
public class Computer {
	private String pcName;
	int score = 0;
	private String fist;
	public void setPcName(int select){
		switch(select){
			case(1):
				this.pcName = "刘备";
				System.out.println("你选择了"+this.pcName+"对战");
				break;
			case(2):
				this.pcName = "孙权";
				System.out.println("你选择了"+this.pcName+"对战");
				break;
			case(3):
				this.pcName = "曹操";
				System.out.println("你选择了"+this.pcName+"对战");
				break;
			default:
				System.out.println("选择错误！");
		}
	}
	public String getPcName(){
		return this.pcName;
	}
//	public void setScore(int score){
//		this.score = score;
//	}		
//	public int getScore(int score){
//		return this.score;
//	}		
	public void setFist(){
		int select = new Random().nextInt(3)+1;
		switch(select){
			case 1: this.fist = "剪刀"; break;
			case 2: this.fist = "石头"; break;
			case 3: this.fist = "布"; break;
		}
	}		
	public String getFist(){
		return this.fist;
	}//似乎是不必要
	public void showFist(){
		System.out.println(this.pcName+"出拳："+this.fist);
	}
}
