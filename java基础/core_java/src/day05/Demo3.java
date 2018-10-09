package day05;

import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		 String input = "1 fish 2 fish red fish blue  white fish";
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     s.close(); 
	}
}
