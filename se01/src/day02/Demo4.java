package day02;

public class Demo4 {
	public static void main(String[] args) {
		String regex = "(SB|WQNMLGB|CNM|我擦|坑B)";
		String message = "我擦！德国你个SB！wqnmlgb!";
		message = message.toUpperCase().replaceAll(regex, "*****");
		System.out.println(message);
		
		String str = "a,b,,c,d,f,,,,,";  //后面的","被忽略
		String[] array = str.split(",");
		System.out.println(array.length);
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);//空格
		System.out.println(array[3]);
	}
}
