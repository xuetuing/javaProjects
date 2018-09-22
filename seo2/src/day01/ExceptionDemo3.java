package day01;

public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			Person p = new Person();
			p.setAge(1000);
			System.out.println(p.getAge());
		} catch (Exception e) {
			//����쳣���ֵĶ�ջ��Ϣ
			e.printStackTrace();
			//����쳣���ֵ�ԭ��
			System.out.println(e.getMessage());
		}
		
	}
}

class Person{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0||age>150){
			throw new RuntimeException("����������ֵ�����");
		}
		this.age = age;
	}

	public String toString() {
		return "�ҵ�������:"+ age;
	}
	
	
	
	
}






















