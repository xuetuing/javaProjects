package day05;

import java.util.Arrays;
import java.util.Comparator;

public class StaticInnerClassDemo2 {
	public static void main(String[] args) {
		String[] names = {"学码","学码思科技","学码思","学"};
		
		Arrays.sort(names,new MyComparator());
		System.out.println(Arrays.toString(names));	
		}
	static class MyComparator implements Comparator<String>{  //Compatator 是接口

		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
		
		
	}
}
