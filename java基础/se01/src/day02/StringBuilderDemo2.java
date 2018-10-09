package day02;
/*
 * StringBuilder reverse()
 * 将当前字符串反转
 */
public class StringBuilderDemo2 {
	public static void main(String[] args) {
		String str = "上海自来水来自海上";
		StringBuilder b1 = new StringBuilder(str);
		StringBuilder b2 = new StringBuilder(str);
		b2.reverse();
		/*
		 * StringBuilder，没有实现equals()方法
		 * 所以比较字符串是否相等，要先转换为字符串
		 */
		if(b1.toString().equals(b2.toString()))
			System.out.println("是回文");
		else
			System.out.println("不是回文");
		
		String str1 = "我来自海上";
		StringBuilder b = new StringBuilder(str1);
		System.out.println(b.reverse());
		
		
		
	}
}
