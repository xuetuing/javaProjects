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
		System.out.println("---------------��ӭ������Ϸ����---------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("            ****************");
		System.out.println("            **   ��ȭ��ʼ!  **");
		System.out.println("            ****************");
		System.out.println("��ȭ����1.����  2.ʯͷ  3.��");
		System.out.print("ѡ��Է���ɫ:��1.���� 2.��Ȩ 3.�ܲ٣�:");
		pc.setPcName(sc.nextInt());
		System.out.print("���������������");
		user.setName(sc.next());
		System.out.println(user.getName()+" VS "+pc.getPcName()+" ��ս��");
		System.out.println("Ҫ��ʼ�𣿣�y/n�� ");
		String input = sc.next();
		
		//System.out.println("��ѡ����"+pc.getPcName()+"��ս");
		while(true){
			if(input.charAt(0) == 'n'){
				System.out.println("----------------------------");
				System.out.println(user.getName()+" VS "+pc.getPcName());
				System.out.println("��ս������"+count);
				System.out.println("����"+"\t"+"�÷�");
				System.out.println(user.getName()+"\t"+user.score);
				System.out.println(pc.getPcName()+"\t"+pc.score);
				if(user.score>pc.score){
					System.out.println("�������ϲ��ϲ!");
				}else{
					System.out.println("��������ź�����ûӮ��");
				}
				break;
			}
			
			System.out.print("���ȭ��1.����  2.ʯͷ  3.������������Ӧ���֣���");
			int select = sc.nextInt();
			user.setFist(select);
			System.out.println("���ȭ��"+user.getFist());
			pc.setFist();
			System.out.println(pc.getPcName()+"��ȭ��"+pc.getFist());
			//�ȽϽ��
			if(showResult(select,pc.getFist()) == 1){
				System.out.println("�������Ӯ�ˣ�");
				user.score++;				
			}else if(showResult(select,pc.getFist()) == 0){
				System.out.println("����������ˣ�");
				pc.score++;
			}
			count++;
			System.out.println();
			System.out.print("�Ƿ������һ�֣���y/n�� ");
			input = sc.next();
		}
	}
	public static int showResult(int select,String fist){
		switch(select){
				case 1:
					if(fist == "��"){
						return 1;
					}else if(fist == "ʯͷ"){
						return 0;
					}else{
						System.out.println("ƽ��");
				}
					break;
				case 2:if(fist == "����"){
						return 1;
					}else if(fist == "��"){
						return 0;
					}else{
							System.out.println("ƽ��");
				}
					break;
				case 3:if(fist == "ʯͷ"){
					return 1;
				}else if(fist == "����"){
					return 0;
				}else{
						System.out.println("ƽ��");
			}
					break;
				default:
					System.out.println("�����������������ѡ��");
					
			}
		return -1;
	}
	public static void main(String[] args) {
		//first play game ,should creat account
		
		startGame();
		
	}
}











