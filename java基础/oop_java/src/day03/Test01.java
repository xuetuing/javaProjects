package day03;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		FlyingObject[] enemy = new FlyingObject[5];
		enemy[3] = new Airplane(54,38,76,83);
		enemy[1] = new Airplane(202,120,76,83);
		enemy[2] = new Bee(58,196,20);
		enemy[0] = new Bee(104,281,20);
		enemy[4] = new Bee(125,46,20);
		//System.out.println(Arrays.toString(enemy));//�˴�toString()�ľ�����̣���
		//�ӵ�������                                                                             ���õ���airplane �� Bee�о����toString()
		int x = 64;int y = 204;
		/*
		 * ����Ƿ񱻻��У�
		 */
//		for(int i=0;i<enemy.length;i++){
//			//ִ�з�����ʱ��ִ�е���enemy[i]��������ö���
//			if(enemy[i].shootBy(x, y)){
//				System.out.println(i+"�����У�");
//			}
//		}
		//ɾ������еķ�����
		//int flg = -1;
		int count = 0;
		FlyingObject[] enemy0 = new FlyingObject[5];
		for(int i=0;i<enemy.length;i++){
			if(enemy[i].shootBy(x, y)){
				count++;
				System.out.println(i+"�����У�");
				enemy[i] = enemy[enemy.length-count];
				enemy0 = Arrays.copyOf(enemy0, enemy0.length-count);
				System.arraycopy(enemy, 0, enemy0, 0, enemy.length-count);
			}
			
		}
		System.out.println(Arrays.toString(enemy0));
	}
}


















