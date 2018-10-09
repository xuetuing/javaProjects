package day03;

public class IntegerDemo1 {
	public static void main(String[] args) {
		/*
		 * 包装类允许通过构造方法将基本类型转换为对应的包装类实例
		 */
		Integer i = new Integer(1);
		Long l = new Long(1);
		Double d = new Double(1.0);
		
		Integer i1 = new Integer(1);
		System.out.println(i == i1);
		System.out.println(i.equals(i1));//包装类重写了equals()方法
		
		/*
		 * 创建包装类实例时推荐使用包装了提供的静态方法
		 * valueOf()
		 */
		Integer n1 = Integer.valueOf(127);
		Integer n2 = Integer.valueOf(127);
		/*
		 * Integer的valueOf()方法的好处在于会将字面量
		 * 的值缓存，并重用，其缓存的范围是一个字节（byte）的值
		 */
		System.out.println(n1 == n2);//true 会缓存
		
		Double d1 = Double.valueOf(1.0);
		Double d2 = Double.valueOf(1.0);
		System.out.println(d1 == d2);//false  无缓存
		
		Long l1 = Long.valueOf(1);
		Long l2 = Long.valueOf(1);
		System.out.println(l1 == l2);//true  会缓存
		
		/*
		 * 从包装类转换为基本类型
		 * 包装类都支持一个方法：xxxValue()
		 */
		int in = i.intValue();
		double db = d1.doubleValue();
		System.out.println(in+","+db);
	}
}




























