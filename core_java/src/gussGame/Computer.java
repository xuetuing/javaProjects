package gussGame;

import java.util.Random;
public class Computer {
	private String pcName;
	int score = 0;
	private String fist;
	public void setPcName(int select){
		switch(select){
			case(1):
				this.pcName = "����";
				System.out.println("��ѡ����"+this.pcName+"��ս");
				break;
			case(2):
				this.pcName = "��Ȩ";
				System.out.println("��ѡ����"+this.pcName+"��ս");
				break;
			case(3):
				this.pcName = "�ܲ�";
				System.out.println("��ѡ����"+this.pcName+"��ս");
				break;
			default:
				System.out.println("ѡ�����");
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
			case 1: this.fist = "����"; break;
			case 2: this.fist = "ʯͷ"; break;
			case 3: this.fist = "��"; break;
		}
	}		
	public String getFist(){
		return this.fist;
	}//�ƺ��ǲ���Ҫ
	public void showFist(){
		System.out.println(this.pcName+"��ȭ��"+this.fist);
	}
}
