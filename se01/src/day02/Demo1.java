package day02;

public class Demo1 {
	public static void main(String[] args) {
		//��֤��ǰ�ַ����Ƿ�����������ʽ�涨�ĸ�ʽ
		/*
		 * �����������ʽ
		 * cuiyefu15264@163.com
		 */
		  //String s = "^.+\\@.+(\\.com)?(\\.cn)?$";                                                                                                                                          
		//String s1 = "^\\w+@\\w+(\\.com)?(\\.cn)?$";
		String s = "^\\w+@\\w+(\\.com|\\.cn|\\.com\\.cn)$"; //'|'ǰ���пո������ɴ���
		System.out.println(s);
		String email = "cuiyefu15264@163.com";
		if(email.matches(s)){
			System.out.println("������");
		}else{
			System.out.println("��������");
		}
		
		Integer a = new Integer(1);
		int b = a.intValue();
		System.out.println(b);
		
	}
}
