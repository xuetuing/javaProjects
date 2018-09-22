package action;

import java.util.ArrayList;
import java.util.List;

import entity.Admin;

public class TagAction {
	private String name;
	private int age;
	private List<Admin> list;
	public String execute(){
		age = 30;
		name = "rose";
		Admin a1 = new Admin();
		a1.setUsername("jack");
		Admin a2 = new Admin();
		a1.setUsername("java");
		list = new ArrayList<Admin>();
		list.add(a1);
		list.add(a2);
		return "success";
	}

	public List<Admin> getList() {
		return list;
	}

	public void setList(List<Admin> list) {
		this.list = list;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
