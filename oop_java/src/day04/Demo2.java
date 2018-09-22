package day04;

public class Demo2 {
	private String name;
	private int age;
	private char sex;
	
	public Demo2(){}
	public Demo2(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override   //��д            overload ����
	public String toString() {
		return "Demo2 [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
