package flying;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//JPanel中存在反序列化，不写会出现警告】
@SuppressWarnings("serial")
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	public static BufferedImage airplane;
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage start;
	public static BufferedImage pause;
	private Timer timer1;
	private Timer timer2;
	private Timer timer3;
	
	int interval = 15;//间隔时间
	int flyEnteredIndex = 10;
	int shootIndex = 0;
	private int score = 0;
	private int state;
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAMEOVER = 3;
	
	public Hero hero = new Hero();
	public Bullet[] bullets = {};
	public FlyingObject[] flyings = {};
	
	public ShootGame(){
		flyings = new FlyingObject[2];
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
		bullets = new Bullet[1];
		bullets[0] = new Bullet(196,350);
	}
	//加载图片
	static{
		try {
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//将图片添加进面板，
	public void paint(Graphics g){
		paintBackground(g);
		paintHero(g);
		paintBullets(g);
		paintFlyingObject(g);
		paintScore(g);
		paintState(g);
	}
	//画背景
	public void paintBackground(Graphics g){
		g.drawImage(background,0,0,null);
	}
	//画子弹的方法
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			g.drawImage(bullets[i].image,bullets[i].x,bullets[i].y,null);
		}
	}
	//画飞行物的方法
	public void paintFlyingObject(Graphics g){
		for(int i=0;i<flyings.length;i++){
			g.drawImage(flyings[i].image,flyings[i].x,flyings[i].y,null);
		}
	}
	//画英雄机的方法
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	//画分数和命
	public void paintScore(Graphics g){
		int x = 0;
		int y = 25;
//		Font font = new Font(Font.SANS_SERIF,Font.BOLD,25);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		g.setColor(new Color(0,220,0));
		g.drawString("SCORE:"+score,x,y);
		g.drawString("LIFE:"+hero.getLife(),x,y+30);
	}
	//画状态
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause,0,0,null);
			break;
		case GAMEOVER:
			g.drawImage(gameover,0,0,null);
			break;
		}
	}
	
	//事件（主要的动作逻辑）
	public void action(){
		MouseAdapter ma = new MouseAdapter(){
			//鼠标移动
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x,y);
				}
			}
			//鼠标点击
			public void mouseClicked(MouseEvent e){
				switch(state){
				case START:
					state = RUNNING;
					break;
				case GAMEOVER:
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					score = 0;
					state = START;
					break;
				}
			}
			//鼠标移出事件
			 public void mouseExited(MouseEvent e){
				 if(state == RUNNING){
					 state = PAUSE;
				 }
			 }
			 //鼠标移入
			 public void mouseEntered(MouseEvent e){
				 if(state == PAUSE){
					 state = RUNNING;
				 }
			 }
		};
		addMouseListener(ma);
		addMouseMotionListener(ma);
		
		timer1 = new Timer();
		timer2 = new Timer();
		//进程
		
		timer1.schedule(new TimerTask(){
			public void run(){
//				if(state == RUNNING){
//					enterAction();   //飞行物进入
//					stepAction();	//飞行物和子弹的运动
//					shootAction();	//子弹发射
//					bangAction();	//碰撞事件
//					outOfBoundsAction();	//出界
//					checkGameOverAction();	//游戏结束
//				}
//				repaint();//重置刷新+
				addSpeed();
				if(score>50){
					timer1.cancel();
					timer2.schedule(new TimerTask(){
						@Override
						public void run() {
//							if(state == RUNNING){
//								enterAction();   //飞行物进入
//								stepAction();	//飞行物和子弹的运动
//								shootAction();	//子弹发射
//								bangAction();	//碰撞事件
//								outOfBoundsAction();	//出界
//								checkGameOverAction();	//游戏结束
//							}
//							repaint();//重置刷新+
							addSpeed();
						}
						
					}, interval, interval-10);
				}
			}
		}, interval, interval);
		
//		timer1 = new Timer();
//		timer2 = new Timer();
//		timer3 = new Timer();
//		
//		class Task extends TimerTask{
//			@Override
//			public void run() {
//				if(state == RUNNING){
//					enterAction();   //飞行物进入
//					stepAction();	//飞行物和子弹的运动
//					shootAction();	//子弹发射
//					bangAction();	//碰撞事件
//					outOfBoundsAction();	//出界
//					checkGameOverAction();	//游戏结束
//				}
//				repaint();//重置刷新+
//			}
//		}
//		timer1.schedule(new Task(){
//			if(score>50){
//				timer1.cancel();
//			}
//		}, interval, interval);
		
			
	}
	//游戏加速
	public void addSpeed(){
		if(state == RUNNING){
			enterAction();   //飞行物进入
			stepAction();	//飞行物和子弹的运动
			shootAction();	//子弹发射
			bangAction();	//碰撞事件
			outOfBoundsAction();	//出界
			checkGameOverAction();	//游戏结束
		}
		repaint();//重置刷新+
	}

	//判断飞行物出界事件
	public void outOfBoundsAction(){
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		Bullet[] bullet = new Bullet[bullets.length];
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].outOfBounds()==false){
				flyingLives[index++] = flyings[i];
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		index = 0;
		for(int i=0;i<bullets.length;i++){
			if(bullets[i].outOfBounds()==false){
				bullet[index++] = bullets[i];
			}
		}
		bullets = Arrays.copyOf(bullet, index);
		
	}
	//检查游戏结束事件
	public void checkGameOverAction(){
		if(isGameOver()){
			state = GAMEOVER;
		}
	}
	//判断游戏结束
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){
			int index = -1;
			if(hero.hit(flyings[i])){
				hero.subtractLife();
				hero.setDoubleFire(0);
				index = i;
			}
			if(index!=-1){
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0;
	}
	//击中事件
	public void bangAction(){
		//int inb = -1;
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			//inb = i;
			//bang(b,inb);
			bang(b,i);
		}
	}
	//判断子弹是否打中飞行物
	public void bang(Bullet b,int inb){
		int index = -1;
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].shootBy(b)){
				index = i;
				break;
			}
		}
		
		if(index != -1){   
			Bullet bs = bullets[inb];
			bullets[inb] = bullets[bullets.length-1];
			bullets[bullets.length-1] = bs;
			bullets = Arrays.copyOf(bullets, bullets.length-1);	 //删除子弹
			
			FlyingObject one = flyings[index];
			//FlyingObject f = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = one;
			flyings = Arrays.copyOf(flyings, flyings.length-1);//删除飞行物
			
			if(one instanceof Enemy){
				Enemy e = (Enemy)one;
				score += e.getScore();
			}else if(one instanceof Award){
				Award a = (Award)one;
				int type = a.getType();
				switch(type){
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				default:
					break;
				}
			}
		}
	}
	//发射事件
	public void shootAction(){
		shootIndex++;
		if(shootIndex%30==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	//飞行物和子弹的运动事件
	public void stepAction(){
		//飞行物的运动
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		//子弹的运动
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		//英雄机的运动
		hero.step();
	}
	
	//飞行物进入事件
	public void enterAction(){
		flyEnteredIndex++;
		if(flyEnteredIndex%60==0){
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings,flyings.length+1);
			flyings[flyings.length-1] = obj;
		}
	}
	//区分敌机和小蜜蜂出现的概率，往面板中补充飞行物
	public static FlyingObject nextOne(){
		Random rd = new Random();
		int type = rd.nextInt(20);
		if(type == 0){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");//创建窗口对象
		ShootGame panel = new ShootGame();
		panel.setBackground(Color.lightGray);
		frame.add(panel);
		
		frame.setSize(WIDTH,HEIGHT);//设置窗口大小
		frame.setResizable(false);//设置窗口大小固定
		frame.setAlwaysOnTop(true);//设置窗口在最上层显示
		
		frame.setVisible(true);//设置可见
		frame.setLocationRelativeTo(null);//设置居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭时程序退出
		
		JLabel label = new JLabel();//窗机标签对象
		label.setText("欢迎来到飞机大战");//给标签设计文本
		Font font = new Font("宋体",Font.BOLD,30);//创建字体对象，字体，字形，大小、
		label.setFont(font);
		panel.add(label);
		
		panel.action();
	}
	
}
