package action;

public class WelcomeAction {
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String execute(){
		age = 32;
		return "success";
	}
	
}
