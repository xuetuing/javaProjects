package day03.question;

import java.util.Arrays;

public class Question {
	int id;
	String text;
	String[] options;
	public Question(){}
	public void print(){
		System.out.println("题目："+this.id+"."+this.text);
		System.out.println("选项："+Arrays.toString(options));
		//for(){}
		
	}
//	public boolean check(String answer){
//		return false;
//	}
	public boolean check(char[] answer){
		return false;
	}
}
