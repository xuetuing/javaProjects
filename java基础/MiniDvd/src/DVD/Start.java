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
		System.out.println("欢迎使用迷你DVD管理器");
		System.out.println("----------------------------");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.退	出");
		System.out.println("");
		
	}
	public static void returnMain(){
		startMenu();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		startMenu();
		
		System.out.print("请选择:");
		select = sc.nextInt();
		while(true){
			if(select==0)
				startMenu();
			switch(select){
			case 1:
				System.out.println("--->新增DVD");
				dvdInfo.add();
				break;
			case 2:
				System.out.println("--->查看DVD");
				dvdInfo.search();
				break;
			case 3:
				System.out.println("--->删除DVD");
				dvdInfo.delete();
				break;
			case 4:
				System.out.println("--->借出DVD");
				dvdInfo.send();
				break;
			case 5:
				System.out.println("--->归还DVD");
				dvdInfo.giveBack();
				break;
			case 6:
				System.out.println("--->退出");
				return;
			}
			System.out.print("请选择:");
			select = sc.nextInt();
		}
		
		
	}
	
	
}













