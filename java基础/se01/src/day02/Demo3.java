package day02;

public class Demo3 {
	public static void main(String[] args) {
//		String str = "qewf afdmao  sfaww  fafoa sfw";
		//���ݿհײ���ַ���
//		String[] array = str.split("\\s+");
//		System.out.println(array.length);
//		for(int i=0;i<array.length;i++){
//			System.out.println(array[i]);
//		}
		String str = "SFQWIE45EWE15WE4863FEWF313";			
		//ǿ�ַ��������ֲ����滻��"#NUMBER#"
		String str1 = str.replaceAll("\\d+", "#NUMBER#");
		System.out.println(str1);
	}
}
