package gussGame;

public class Customer {
	private String name;
	int score = 0;
	private String fist;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
//	public void setScore(int score){
//		this.score = score;
//	}
//	public int getScore(){
//		return this.score;
//	}
	public void setFist(int select){
		switch(select){
		case(1):
			this.fist = "剪刀";
			break;
		case(2):
			this.fist = "石头";
			break;
		case(3):
			this.fist = "布";
			break;
		default:
			System.out.println("你出拳不对.");
			break;
		}
	}
	public String getFist(){
		return this.fist;
	}
	public void showFist(){
		System.out.println("你出拳："+this.fist);
	}
}
