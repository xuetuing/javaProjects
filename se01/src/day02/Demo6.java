package day02;
/*
 * �ַ����������
 * �ô������̶ȵ�����,��ʡ�ռ䣨���ڴ�ռ䣩
 * �׶ˣ�����Ƶ���޸��ַ���ʱ�ᴴ�����ɶ���
 */
public class Demo6 {
	public static void main(String[] args) {
		String str = "a";
//		for(int i =0;i<50;i++){    //outofmem�����
//			str += str;
//		}
//		System.out.println(str);
		
		StringBuilder builder = new StringBuilder(str);
		for(int i =0;i<50;i++){  
			builder.append("a");
		}
		System.out.println(builder);
	}
}
 