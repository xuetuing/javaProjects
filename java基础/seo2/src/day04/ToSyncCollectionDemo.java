package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//����Collections���̲߳���ȫ����ת��Ϊ�̰߳�ȫ�ļ���
public class ToSyncCollectionDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * ��ArrayListת��Ϊһ���̰߳�ȫ�ļ��ϣ�ԭ�����е�
		 * Ԫ����Ȼ����
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		Set<String> set = new HashSet<String>();
		set = Collections.synchronizedSet(set);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map = Collections.synchronizedMap(map);
		
		
		
		
 	}
}