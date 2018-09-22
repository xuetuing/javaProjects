package day03;

public class IntegerDemo2 {
	public static void main(String[] args) {
		Object[] arr = new Object[10];
		//当我们需要将基本类型作为引用类型看待时:
		arr[0] = Integer.valueOf(1);
		/*
		 * 下面的语法在JDK1.5之前是非法的，但1.5之后则是
		 * 可以的，1.5之后推出了新特性：自动拆装箱
		 */
		arr[0] = 1;//自动将基本类型转换为包装类：自动装箱
		Integer i = (Integer)arr[0];
		//如果需要将包装类保存的基本类型数据获取到时：
		int in = i.intValue();
		/*
		 * 当遇到需要将包装类转换成基本类型数据时，会自动调用其对
		 * 应的xxxValue()方法：自动拆箱
		 */
		in = i;  //自动拆箱
		
	}
}





























