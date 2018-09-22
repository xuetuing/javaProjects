package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCollectionDemo1 {
	public static void main(String[] args) {
		List<Point1> list = new ArrayList<Point1>();
		list.add(new Point1(1,5));
		list.add(new Point1(3,4));
		list.add(new Point1(2,2));
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}
}


















