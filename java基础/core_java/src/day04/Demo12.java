package day04;

import java.util.Random;
import java.util.Scanner;

public class Demo12 {
	public static void main(String[] args) {
		//��������Ϸ
		//��һ�����ݷ����������ҵ�����
		/*
		 * num   �²������
		 * answer  �û��²�Ĵ�
		 * count   �²�Ĵ���
		 * 1.���������num[1~100]
		 * 2.��ʾ�û���ʼ�²�
		 * 3.�õ��²�Ĵ�anwser
		 * 4.�Ƚ�answer��num
		 *   ����count++
		 *   ������break
		 *   �������ȣ���ʾ�´���/��С��
		 *   ���ص�2��
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int answer;
		int count=0;
		int num = rd.nextInt(100)+1;
		System.out.println("�²����֣�");
		while(true){
			answer = sc.nextInt();
			count++;
			if(answer == num){
				System.out.println("�²���ȷ��"+num+","+"����"+count+"��");
				break;
			}else if(answer>num){
				System.out.println("�´��ˣ�");
				System.out.print("�����²����֣�");
			}else{
				System.out.println("��С�ˣ�");
				System.out.print("�����²����֣�");
			}
			//count++;
		}
		//System.out.println("�²������"+count);
	}
}
