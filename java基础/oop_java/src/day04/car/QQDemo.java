package day04.car;

public class QQDemo {
	public static void main(String[] args) {
		//Car c = new Car();
		//Car c = new QQ(); //可以引用实现的类
		QQ qq = new QQ();
		Prodcut p = qq;  //QQ与prodcut的关系类似QQ继承了Prodcut，p可引用qq
		System.out.println(p.getPrice());
		
		Car c = qq;   //
		c.run();
		c.stop();
		Car car = (Car)p;//接口之间可以相互引用？
		//Car car = p; //这种写法错误，无法转型
		car.run();
		car.stop();
	}
}
