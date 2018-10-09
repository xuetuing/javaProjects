package day03.question;

public class SingleQuestion extends Question{
	private char answer;
	public SingleQuestion(int id,String text,String[] options,char answer){
		this.id = id;
		this.text = text;
		this.options = options;
		this.answer = answer;
	}
//	public boolean check(String answer){    //��String,�ڷ������н�String��Ϊchar
//		if(answer.charAt(0) == this.answer){
//			return true;
//		}else{
//			return false;
//		}
//	}
	public boolean check(char[] answer){
		if(answer == null || answer.length!=1){  //д����ʱ��ע���ж����������������ȫ
			return false;
		}
		return this.answer == answer[0];
	}
}
