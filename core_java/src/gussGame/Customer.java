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
			this.fist = "����";
			break;
		case(2):
			this.fist = "ʯͷ";
			break;
		case(3):
			this.fist = "��";
			break;
		default:
			System.out.println("���ȭ����.");
			break;
		}
	}
	public String getFist(){
		return this.fist;
	}
	public void showFist(){
		System.out.println("���ȭ��"+this.fist);
	}
}
