package day05;

import java.util.HashSet;
import java.util.Set;

public class SetElementDemo1 {
	public static void main(String[] args) {
		Set<Element> set = new HashSet<Element>();
		Element e1 = new Element(1);
		Element e2 = new Element(1);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode()==e2.hashCode());
		
		set.add(e1);
		set.add(e2);
		System.out.println(set.size());
	}
}
