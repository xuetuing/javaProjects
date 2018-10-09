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
		//System.out.println(Arrays.toString(enemy));//此处toString()的具体过程？？
		//子弹的坐标                                                                             调用的是airplane 和 Bee中具体的toString()
		int x = 64;int y = 204;
		/*
		 * 检查是否被击中；
		 */
//		for(int i=0;i<enemy.length;i++){
//			//执行方法的时候，执行的是enemy[i]具体的引用对象
//			if(enemy[i].shootBy(x, y)){
//				System.out.println(i+"被击中！");
//			}
//		}
		//删除别击中的飞行物
		//int flg = -1;
		int count = 0;
		FlyingObject[] enemy0 = new FlyingObject[5];
		for(int i=0;i<enemy.length;i++){
			if(enemy[i].shootBy(x, y)){
				count++;
				System.out.println(i+"被击中！");
				enemy[i] = enemy[enemy.length-count];
				enemy0 = Arrays.copyOf(enemy0, enemy0.length-count);
				System.arraycopy(enemy, 0, enemy0, 0, enemy.length-count);
			}
			
		}
		System.out.println(Arrays.toString(enemy0));
	}
}


















