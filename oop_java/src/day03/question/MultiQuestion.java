package day03.question;

import java.util.Arrays;

public class MultiQuestion extends Question{
	private char[] answer;
	public MultiQuestion(int id,String text,String[] options,char[] answer){
		this.id = id;
		this.text = text;
		this.options = options;
		this.answer = answer;
	}
//	public boolean check(String answer){
//		if(answer.equals(Arrays.toString(this.answer))){  //将char[] 变为String,利用String.equals()比较
//			return true;
//		}else{
//			return false;
//		}
//		
//	}
	public boolean check(char[] answer){
		return Arrays.equals(this.answer, answer);
	}
}
