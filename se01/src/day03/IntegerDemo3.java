package day03;

public class IntegerDemo3 {
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		
		//�ַ�����ʽ������ȫƥ��������͵�ֵ
		String str = "123";
		int i = Integer.parseInt(str);
		System.out.println(i);
		
		/*
		 * Integer�ṩ������������
		 * ���Ի�ȡһ�������Ķ����ˣ�ʮ�����Ƶ���ʽ
		 */
		String bstr = Integer.toBinaryString(100);  //������
		System.out.println(bstr);
	
		String ostr = Integer.toOctalString(100);//�˽���
		System.out.println(ostr);
		
		String hstr = Integer.toHexString(100);//ʮ������
		System.out.println(hstr);
	}
}



























































