package day05;
//����Ԫ�ص�equals()��hashCode()����д����
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
		if (this == obj)  //�Ƚϵ�ַ
			return true;
		if (obj == null) //��������Ƿ�Ϊ��
			return false;
		if (getClass() != obj.getClass())//�Ƚ�����
			return false;
		Element other = (Element) obj;
		if (x != other.x)	//�Ƚ�����
			return false;
		return true;
	}
	
}












