package day03;
public class Demo2 {
	public static void main(String[] args){
		long l = 5;
		long l1 = 5L;
		l = 8L;
		int x = (int)l;
		System.out.println(x);
		x = (int)l;
		double pi = Math.PI;
		float f = (float)pi;
		l = (long)pi;
		System.out.println(pi);
		System.out.println(f);
		System.out.println(l);
		//byte short char�ײ����㶼����int������
		byte b1 = 2;
		byte b2 = 2;
		byte b3 = (byte)(b1 + b2); //�˲�������int���ͼ����
		char c = 'A' + 1; //�������Ż�
		char ch = 'A';
		c = (char)(ch + 1);
		System.out.println(c);
	}
}
