package day03;

public class Demo9 {
	public static void main(String [] args){
		int a = 5;
		int b = 4;
		int c = a + b;
//		System.out.println(c);
		String s = "5" + 5;  //�ַ�������
//		System.out.println(s);
		System.out.println(1+2+"ABC");
		System.out.println(1+'2'+"ABC"); //char ������int���ͼ��㣬ֻҪ��String���ͣ��ͻᷢ������
		System.out.println('1'+2+3+"ABC");//��������˳�򣬴����ң����int�ͻᷢ���������㣬��String�������ʱ��ֻ��������
		System.out.println("ABC"+1+2);//����String ��ǰʱ��'+'������ȫ��Ϊ����
	}
}
