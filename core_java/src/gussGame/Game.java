package gussGame;

import java.util.Scanner;

public class Game {
	public static void inital(){
		//Customer user = new Customer();
		//Computer pc = new Computer();
		
	}//?
	public static void startGame(){
		Scanner sc = new Scanner(System.in);
		Customer user = new Customer();
		Computer pc = new Computer();
		int count = 0;
		System.out.println("---------------欢迎进入游戏世界---------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("            ****************");
		System.out.println("            **   猜拳开始!  **");
		System.out.println("            ****************");
		System.out.println("出拳规则：1.剪刀  2.石头  3.布");
		System.out.print("选择对方角色:（1.刘备 2.孙权 3.曹操）:");
		pc.setPcName(sc.nextInt());
		System.out.print("请输入你的姓名：");
		user.setName(sc.next());
		System.out.println(user.getName()+" VS "+pc.getPcName()+" 对战！");
		System.out.println("要开始吗？（y/n） ");
		String input = sc.next();
		
		//System.out.println("你选择了"+pc.getPcName()+"对战");
		while(true){
			if(input.charAt(0) == 'n'){
				System.out.println("----------------------------");
				System.out.println(user.getName()+" VS "+pc.getPcName());
				System.out.println("对战次数："+count);
				System.out.println("姓名"+"\t"+"得分");
				System.out.println(user.getName()+"\t"+user.score);
				System.out.println(pc.getPcName()+"\t"+pc.score);
				if(user.score>pc.score){
					System.out.println("结果：恭喜恭喜!");
				}else{
					System.out.println("结果：很遗憾，你没赢！");
				}
				break;
			}
			
			System.out.print("请出拳：1.剪刀  2.石头  3.布（请输入相应数字）：");
			int select = sc.nextInt();
			user.setFist(select);
			System.out.println("你出拳："+user.getFist());
			pc.setFist();
			System.out.println(pc.getPcName()+"出拳："+pc.getFist());
			//比较结果
			if(showResult(select,pc.getFist()) == 1){
				System.out.println("结果：你赢了！");
				user.score++;				
			}else if(showResult(select,pc.getFist()) == 0){
				System.out.println("结果：你输了！");
				pc.score++;
			}
			count++;
			System.out.println();
			System.out.print("是否进入下一轮？（y/n） ");
			input = sc.next();
		}
	}
	public static int showResult(int select,String fist){
		switch(select){
				case 1:
					if(fist == "布"){
						return 1;
					}else if(fist == "石头"){
						return 0;
					}else{
						System.out.println("平局");
				}
					break;
				case 2:if(fist == "剪刀"){
						return 1;
					}else if(fist == "布"){
						return 0;
					}else{
							System.out.println("平局");
				}
					break;
				case 3:if(fist == "石头"){
					return 1;
				}else if(fist == "剪刀"){
					return 0;
				}else{
						System.out.println("平局");
			}
					break;
				default:
					System.out.println("输入错误！请重新输入选择");
					
			}
		return -1;
	}
	public static void main(String[] args) {
		//first play game ,should creat account
		
		startGame();
		
	}
}











