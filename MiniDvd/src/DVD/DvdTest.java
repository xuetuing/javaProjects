package DVD;

import java.util.Scanner;

public class DvdTest {
	public static void main(String[] args) {
		Start manager = new Start();
		Scanner sc = new Scanner(System.in);
		int select;
		
		System.out.print("��ѡ��:");
		select = sc.nextInt();
		manager.startMenu();
	}
}
