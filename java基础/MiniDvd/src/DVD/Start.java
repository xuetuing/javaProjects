package DVD;

import java.util.Scanner;

public class Start {
	public static DvdMgr dvdInfo = new DvdMgr();
//	public static void main(String[] args) {
//		DvdMgr dvdInfo = new DvdMgr();
//		dvdInfo.init();
//		for(int i=0;i<50;i++){
//			System.out.println(dvdInfo.name[i]);
//		}
//		
//	}
	static int select;
	public static void startMenu(){
		System.out.println("��ӭʹ������DVD������");
		System.out.println("----------------------------");
		System.out.println("1.����DVD");
		System.out.println("2.�鿴DVD");
		System.out.println("3.ɾ��DVD");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.��	��");
		System.out.println("");
		
	}
	public static void returnMain(){
		startMenu();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		startMenu();
		
		System.out.print("��ѡ��:");
		select = sc.nextInt();
		while(true){
			if(select==0)
				startMenu();
			switch(select){
			case 1:
				System.out.println("--->����DVD");
				dvdInfo.add();
				break;
			case 2:
				System.out.println("--->�鿴DVD");
				dvdInfo.search();
				break;
			case 3:
				System.out.println("--->ɾ��DVD");
				dvdInfo.delete();
				break;
			case 4:
				System.out.println("--->���DVD");
				dvdInfo.send();
				break;
			case 5:
				System.out.println("--->�黹DVD");
				dvdInfo.giveBack();
				break;
			case 6:
				System.out.println("--->�˳�");
				return;
			}
			System.out.print("��ѡ��:");
			select = sc.nextInt();
		}
		
		
	}
	
	
}













