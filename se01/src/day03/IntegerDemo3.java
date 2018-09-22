package day03;

public class IntegerDemo3 {
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		
		//字符串格式必须完全匹配基本类型的值
		String str = "123";
		int i = Integer.parseInt(str);
		System.out.println(i);
		
		/*
		 * Integer提供了三个方法：
		 * 可以获取一个整数的二，八，十六进制的形式
		 */
		String bstr = Integer.toBinaryString(100);  //二进制
		System.out.println(bstr);
	
		String ostr = Integer.toOctalString(100);//八进制
		System.out.println(ostr);
		
		String hstr = Integer.toHexString(100);//十六进制
		System.out.println(hstr);
	}
}



























































