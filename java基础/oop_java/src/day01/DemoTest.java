package day01;

public class DemoTest {
	public static void main(String[] args) {
		Book p;//声明了一个Book类型的引用变量bk;
		p = new Book(); //创建了对象，bk的值是地址，是对象在堆中的地址
		p.name = "novel";
		System.out.println(p.name);
	}
}
