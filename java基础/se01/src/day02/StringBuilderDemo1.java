package day02;
/*
 * StringBuilder对字符串的操作：
 * append()  insert()  delete()  replace()
 * 使用方式：builder.append()
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "好好学习Python";
		StringBuilder builder = new StringBuilder(str);
		
		builder.append(",为了找个好工作");
		builder.replace(13, builder.length(), "改变世界");
		builder.delete(0,11);
		builder.insert(0,"活着,");
		//builder.replace(2,3,"就是");
		builder.delete(2,3);
		builder.insert(2,"就是");
		System.out.println(builder);  //builder 重写了toString()方法
		
		
		
	}
}
