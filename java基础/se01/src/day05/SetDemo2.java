package day05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//����Set����
public class SetDemo2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		//Set�洢����hashCode()
		set.add("one");
		set.add("two");
		set.add("three");
		//����������
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//foreachѭ��
		for(String str : set){
			System.out.println(str);
		}
		
		
		
	}
	
}
