package day01;

public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			Person p = new Person();
			p.setAge(1000);
			System.out.println(p.getAge());
		} catch (Exception e) {
			//输出异常出现的堆栈信息
			e.printStackTrace();
			//输出异常出现的原因
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
			throw new RuntimeException("不是人类出现的年龄");
		}
		this.age = age;
	}

	public String toString() {
		return "我的年龄是:"+ age;
	}
	
	
	
	
}






















