package day05;

import java.util.Arrays;
import java.util.Comparator;

public class StaticInnerClassDemo2 {
	public static void main(String[] args) {
		String[] names = {"ѧ��","ѧ��˼�Ƽ�","ѧ��˼","ѧ"};
		
		Arrays.sort(names,new MyComparator());
		System.out.println(Arrays.toString(names));	
		}
	static class MyComparator implements Comparator<String>{  //Compatator �ǽӿ�

		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
		
		
	}
}
