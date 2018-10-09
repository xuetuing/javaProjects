package day02;

public class StringBuilderDemo3 {
	public static void main(String[] args) {
		System.out.println(testBuilder(10000));
		System.out.println(testString(10000));
	}
	//测试String的性能
	public static long testString(int n){
		long start = System.currentTimeMillis();
		String str = "";
		for(int i=0;i<n;i++){
			str += "abc";
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	//测试StringBuilder的性能
	public static long testBuilder(int n){
		long start = System.currentTimeMillis();
		String str = "";
		StringBuilder builder = new StringBuilder(str);
		for(int i=0;i<n;i++){
			builder.append("abc");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
