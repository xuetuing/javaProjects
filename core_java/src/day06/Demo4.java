package day06;

import java.util.Arrays;
//Arrays.fill()
//System.arraycopy()
public class Demo4 {
	public static void main(String[] args) {
//		int[] line = new int[6];
//		System.out.println(Arrays.toString(line));
//		Arrays.fill(line, 8);
//		System.out.println(Arrays.toString(line));
		int[] line = {1,2,3,4,0,0,0,0};
		int[] line1 = {0,0,0,0,5,6,7,8};
		System.arraycopy(line, 0, line1, 0, 4);
		System.out.println(Arrays.toString(line1));
		int[] line2 = {1,2,0,0,5,6,0,0};
		System.arraycopy(line,2,line2,2,2);
		System.arraycopy(line1,6,line2,6,2);
		System.out.println(Arrays.toString(line2));
	}
}
