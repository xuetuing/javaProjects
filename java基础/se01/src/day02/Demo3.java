package day02;

public class Demo3 {
	public static void main(String[] args) {
//		String str = "qewf afdmao  sfaww  fafoa sfw";
		//根据空白拆分字符串
//		String[] array = str.split("\\s+");
//		System.out.println(array.length);
//		for(int i=0;i<array.length;i++){
//			System.out.println(array[i]);
//		}
		String str = "SFQWIE45EWE15WE4863FEWF313";			
		//强字符串中数字部分替换我"#NUMBER#"
		String str1 = str.replaceAll("\\d+", "#NUMBER#");
		System.out.println(str1);
	}
}
