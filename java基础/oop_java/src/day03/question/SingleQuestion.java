package day03.question;

public class SingleQuestion extends Question{
	private char answer;
	public SingleQuestion(int id,String text,String[] options,char answer){
		this.id = id;
		this.text = text;
		this.options = options;
		this.answer = answer;
	}
//	public boolean check(String answer){    //传String,在方法体中将String变为char
//		if(answer.charAt(0) == this.answer){
//			return true;
//		}else{
//			return false;
//		}
//	}
	public boolean check(char[] answer){
		if(answer == null || answer.length!=1){  //写函数时，注意判断例外情况，考虑完全
			return false;
		}
		return this.answer == answer[0];
	}
}
