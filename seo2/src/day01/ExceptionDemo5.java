package day01;

public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {
			test(1,0,2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int test(int a,int b,int c) throws Exception{
		/*
		 * 当我们调用的方法会抛出异常时，而我们的方法也不关心这个异常时，
		 * 我们可以采取在当前方法上继承声明throws，将该异常抛出给下一个
		 * 调用者
		 */
		return divide(a,b)+c;
	}
	/*
	 * 除法操作
	 * 当方法中抛出了一个异常时，该方法的声明就应该书写
	 * throws来声明异常的抛出
	 */
	public static int divide(int a,int b) throws Exception{ //声明这个方法有个异常
		if(b==0){
			throw new Exception("除数不能为0");
		}
		return a/b;
	}
	
	
	
	
}
