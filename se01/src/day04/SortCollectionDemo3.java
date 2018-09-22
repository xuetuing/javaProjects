package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCollectionDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("rwjfwwfwn");
		list.add("FNK");
		list.add("fsfWG");
		list.add("WGglo");
		list.add("GgowGEF");
		list.add("fajofwj");
		/*
		 * 使用额外的比较规则进行排序
		 */
		//Collections.sort(list,new MyComparator());
		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(list);
	}
}

//class MyComparator implements Comparator<String>{
//
//	public int compare(String o1, String o2) {
//		return o1.length() - o2.length();
//	}
//	
//}
























