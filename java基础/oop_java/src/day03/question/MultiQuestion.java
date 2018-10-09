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
//		if(answer.equals(Arrays.toString(this.answer))){  //��char[] ��ΪString,����String.equals()�Ƚ�
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
