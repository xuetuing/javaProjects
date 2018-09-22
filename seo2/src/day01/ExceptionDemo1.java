package day01;
//java异常捕获机制：程序中只能解决Exception，不能解决Error
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		/*
		 * JVM发现要调用一个null的方法，JVM创建一个空指针
		 * 异常的实例来描述这里发生的异常，在当前行抛出异常，
		 * 抛出后，JVM会检查代码片段，查看是否有异常捕获机制
		 * 当发现当前代码行没有异常捕获机制，则将该异常实例抛出到
		 * 当前代码所在的方法之外，当异常逐级抛出到main方法之外时，
		 * JVM会杀掉当前程序，程序退出
		 */
		try {
			//String str = null;
			//String str = "";
			String str = "a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			int i = Integer.parseInt(str);
			System.out.println(i);
			/*
			 * 当上面的代码片段出现了异常，会跳出try语句块，
			 * try语句块中剩下的代码片段不能被执行
			 */
			System.out.println("内容都执行了");
		} catch (NullPointerException e) {
			System.out.println("出现了空指针异常");
		} catch (StringIndexOutOfBoundsException e){
			System.out.println("出现了字符串下标越界异常");
		} catch (Exception e){
			/*
			 * 异常捕获机制的良好习惯：
			 * 在最后一个catch捕获Exception，以保证可捕获程序
			 * 中出现的其他异常，使程序不会出现闪退现象
			 * 
			 */
			System.out.println("出了个错误");
		}
		
		System.out.println("程序结束了");
		
		
	}
}
