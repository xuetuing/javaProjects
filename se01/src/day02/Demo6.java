package day02;
/*
 * 字符串不变对象：
 * 好处：最大程度的重用,节省空间（堆内存空间）
 * 弊端：对于频繁修改字符串时会创建若干对象
 */
public class Demo6 {
	public static void main(String[] args) {
		String str = "a";
//		for(int i =0;i<50;i++){    //outofmem堆溢出
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
 