package day03.question;

import java.util.Arrays;

public class Question {
	int id;
	String text;
	String[] options;
	public Question(){}
	public void print(){
		System.out.println("��Ŀ��"+this.id+"."+this.text);
		System.out.println("ѡ�"+Arrays.toString(options));
		//for(){}
		
	}
//	public boolean check(String answer){
//		return false;
//	}
	public boolean check(char[] answer){
		return false;
	}
}
