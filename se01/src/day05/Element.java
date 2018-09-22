package day05;
//测试元素的equals()与hashCode()的重写规则
public class Element {
	private int x;

	public Element(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)  //比较地址
			return true;
		if (obj == null) //传入对象是否为空
			return false;
		if (getClass() != obj.getClass())//比较类型
			return false;
		Element other = (Element) obj;
		if (x != other.x)	//比较内容
			return false;
		return true;
	}
	
}












