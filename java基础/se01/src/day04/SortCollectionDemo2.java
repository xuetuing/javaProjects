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
		 * sort()ʹ��Ԫ�������ṩ��comparaTo()�����ıȽϽ������
		 */
		Collections.sort(list);
		System.out.println(list);
		
		
		
	}
}
