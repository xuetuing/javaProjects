package day02;
/*
 * StringBuilder reverse()
 * ����ǰ�ַ�����ת
 */
public class StringBuilderDemo2 {
	public static void main(String[] args) {
		String str = "�Ϻ�����ˮ���Ժ���";
		StringBuilder b1 = new StringBuilder(str);
		StringBuilder b2 = new StringBuilder(str);
		b2.reverse();
		/*
		 * StringBuilder��û��ʵ��equals()����
		 * ���ԱȽ��ַ����Ƿ���ȣ�Ҫ��ת��Ϊ�ַ���
		 */
		if(b1.toString().equals(b2.toString()))
			System.out.println("�ǻ���");
		else
			System.out.println("���ǻ���");
		
		String str1 = "�����Ժ���";
		StringBuilder b = new StringBuilder(str1);
		System.out.println(b.reverse());
		
		
		
	}
}
