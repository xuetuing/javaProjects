package day04.car;

public class QQDemo {
	public static void main(String[] args) {
		//Car c = new Car();
		//Car c = new QQ(); //��������ʵ�ֵ���
		QQ qq = new QQ();
		Prodcut p = qq;  //QQ��prodcut�Ĺ�ϵ����QQ�̳���Prodcut��p������qq
		System.out.println(p.getPrice());
		
		Car c = qq;   //
		c.run();
		c.stop();
		Car car = (Car)p;//�ӿ�֮������໥���ã�
		//Car car = p; //����д�������޷�ת��
		car.run();
		car.stop();
	}
}
