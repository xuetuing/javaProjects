package flyings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShootGame extends JPanel{
	public static int WIDTH = 400;
	public static int HEIGHT = 650;
	
	public static BufferedImage airplane;
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage start;
	
	public int score = 0;
	public int shootindex =0;
	public int flyEnterIndex = 0;
	public int interval = 15;
	private Timer timer;
	
	public Hero hero = new Hero();	
	public Bullet[] bullets = {};
	public FlyingObject[] flyings = {};
	private int state;
	private final static int START = 0;
	private final static int RUNNING = 1;
	private final static int PAUSE = 2;
	private final static int GAMEOVER = 3;
	
	public ShootGame(){		
		bullets = new Bullet[1];
		bullets[0] = new Bullet(196,350);
		flyings = new FlyingObject[2];
		flyings[0] = new Bee();
		flyings[1] = new Airplane();
		
	}
	//加载外部资源
	static{
		try {
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//将对象添加进面板，背景，hero,airplane,flyObject,bullet,状态state
	//添加图形总方法
	public void paint(Graphics g){
		paintBackground(g);
		paintHero(g);
		paintFlyingObject(g);
		paintBullets(g);
		paintScore(g);
		paintState(g);
		
	}
	//画背景图
	public void paintBackground(Graphics g){
		g.drawImage(background, 0, 0, null);
		
	}
	//画飞行物，蜜蜂和敌机
	public void paintFlyingObject(Graphics g){
		for(int i=0;i<flyings.length;i++){
			g.drawImage(flyings[i].image, flyings[i].x, flyings[i].y, null);
		}
	}
	//画英雄机
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x,hero.y, null);
	}
	//画子弹
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}
	//画分数
	public void paintScore(Graphics g){
		int x = 0;
		int y = 25;
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
		g.setColor(new Color(0,220,0));
		g.drawString("SCORE:"+score, x, y);
		g.drawString("LIFE:"+hero.getLife(), x, y+30);
	}
	//画状态
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAMEOVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}

	//添加事件(主要动作逻辑)，鼠标监控
	public void action(){
		MouseAdapter mouse = new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
				}
			}
			//鼠标移出
			public void mouseExited(MouseEvent e){
				if(state==RUNNING)
					state = PAUSE;
			}
			//鼠标进入
			public void mouseEntered(MouseEvent e){
				if(state==PAUSE)
					state = RUNNING;
			}
			//鼠标点击
			public void mouseClicked(MouseEvent e){
				switch(state){
				case START:
					state = RUNNING;
					break;
				case GAMEOVER:
					hero = new Hero();
					bullets = new Bullet[0];
					flyings = new FlyingObject[0];
					score = 0;
					state = START;
					break;
				default:
					break;
				}
			}
		};
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				if(state==RUNNING){
					flysEnterAction();
					stepAction();
					shootAction();
					bangAction();
					outOfBoundsAction();
					checkGameoverAction();				
				}
				repaint();
			}
			
		}, interval, interval);
		
	}
	//判断出界事件
	public void outOfBoundsAction(){
		int index = 0;
		FlyingObject[] flyLives = new FlyingObject[flyings.length];
		Bullet[] bulLives = new Bullet[bullets.length];
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].outOfBounds()==false){
				flyLives[index++] = flyings[i];
			}
		}
		flyings = Arrays.copyOf(flyLives, index);
		index = 0;
		for(int i=0;i<bullets.length;i++){
			if(bullets[i].outOfBounds()==false){
				bulLives[index++] = bullets[i]; 
			}
		}
		bullets = Arrays.copyOf(bulLives, index);
	}
	//检查游戏是否结束
	public void checkGameoverAction(){
		if(isGameover()){
			state = GAMEOVER;
		}
	}
	//判断游戏结束
	public boolean isGameover(){
		int index = -1;
		for(int i=0;i<flyings.length;i++){
			if(hero.hit(flyings[i])){
				hero.subtractLife();
				hero.setDoubleFire(0);
				index = i;
			}
		if(index != -1){
			FlyingObject fy = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = fy;
			
			flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0;
	}
	//检查子弹击中事件
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			bang(b,i);
		}
	}
	//判断飞行物是否被子弹中，击中后处理
	public void bang(Bullet b,int ind){
		int index = -1;
		//被击中的飞行物
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].shootBy(b)){
				index = i;
				break;
			}
		}
		if(index!=-1){
			//删除子弹
			Bullet bt = bullets[ind];
			bullets[ind] = bullets[bullets.length-1];
			bullets[bullets.length-1] = bt;
			bullets = Arrays.copyOf(bullets, bullets.length-1);
			//删除飞行物
			FlyingObject fy = flyings[index];
			flyings[index] = flyings[flyings.length-1]; 
			flyings[flyings.length-1] = fy;
			flyings = Arrays.copyOf(flyings, flyings.length-1);
			
			if(fy instanceof Enemy){
				Enemy e = (Enemy)fy;
				score += e.getScore();
			}else if(fy instanceof Award){
				Award a = (Award)fy;
				int type = a.getType();
				switch(type){
				case Award.LIFE:
					hero.addLife();
					break;
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				}
			}
		}
		
		
		
	}
	
	//补充子弹发射
	public void shootAction(){
		shootindex++;
		if(shootindex%30==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	//飞行物运动事件
	public void stepAction(){
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		hero.step();
	}
	//飞行物出现事件
	public void flysEnterAction(){
		flyEnterIndex++;
		if(flyEnterIndex%30==0){
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = obj;
		}
	}
	//小蜜蜂的出现概率
	public FlyingObject nextOne(){
		int type = new Random().nextInt(20); 
		if(type == 0)
			return new Bee();
		else
			return new Airplane();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ShootGame panel = new ShootGame();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel();
		label.setText("欢迎来到飞机大战");
		Font font = new Font("宋体",Font.BOLD,30);
		label.setFont(font);
		
		panel.add(label);
		frame.add(panel);
		
		panel.action();
		
	}
	
	
	
	
	
	
	
	
	
	
}
