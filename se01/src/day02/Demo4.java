package day02;

public class Demo4 {
	public static void main(String[] args) {
		String regex = "(SB|WQNMLGB|CNM|�Ҳ�|��B)";
		String message = "�Ҳ����¹����SB��wqnmlgb!";
		message = message.toUpperCase().replaceAll(regex, "*****");
		System.out.println(message);
		
		String str = "a,b,,c,d,f,,,,,";  //�����","������
		String[] array = str.split(",");
		System.out.println(array.length);
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);//�ո�
		System.out.println(array[3]);
	}
}
