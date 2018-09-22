package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCollectionDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("rwj");
		list.add("FNK");
		list.add("fsfWG");
		list.add("WGglo");
		list.add("GgowGEF");
		list.add("fajofwj");
		/*
		 * sort()使用元素自身提供的comparaTo()方法的比较结果排序
		 */
		Collections.sort(list);
		System.out.println(list);
		
		
		
	}
}
