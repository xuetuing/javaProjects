package day04.FlyWar;

public class Demo {
	public static void main(String[] args) {
		FlyingObject[] objects = new FlyingObject[5];
		objects[0] = new enemyFlying(0,0,20,20);
		objects[1] = new enemyFlying(10,10,20,20);
		objects[2] = new pig(150,26,35);
		objects[4] = new pig(26,45,42);
		objects[3] = new Bee(15,36,98);
		int x = 26; int y = 85;
		for(int i=0;i<objects.length;i++){
			FlyingObject obj = objects[i];
			if(obj instanceof enemy){
				enemy enemy = (enemy)obj;
				if(enemy.shootBy(x, y)){
					System.out.println(enemy+"被击中");
					if(enemy instanceof Award){
						Award award = (Award)enemy;
						System.out.println("奖励是"+(award.getType() == 0?"双倍活力":"命"));
					}
				}
			}
		}
	}
}
