package day02;

public class Demo1 {
	public static void main(String[] args) {
		//验证当前字符串是否满足正则表达式规定的格式
		/*
		 * 邮箱的正则表达式
		 * cuiyefu15264@163.com
		 */
		  //String s = "^.+\\@.+(\\.com)?(\\.cn)?$";                                                                                                                                          
		//String s1 = "^\\w+@\\w+(\\.com)?(\\.cn)?$";
		String s = "^\\w+@\\w+(\\.com|\\.cn|\\.com\\.cn)$"; //'|'前后有空格可能造成错误
		System.out.println(s);
		String email = "cuiyefu15264@163.com";
		if(email.matches(s)){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
		
		Integer a = new Integer(1);
		int b = a.intValue();
		System.out.println(b);
		
	}
}
