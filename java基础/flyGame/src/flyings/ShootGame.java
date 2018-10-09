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
	//�����ⲿ��Դ
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
	//��������ӽ���壬������hero,airplane,flyObject,bullet,״̬state
	//���ͼ���ܷ���
	public void paint(Graphics g){
		paintBackground(g);
		paintHero(g);
		paintFlyingObject(g);
		paintBullets(g);
		paintScore(g);
		paintState(g);
		
	}
	//������ͼ
	public void paintBackground(Graphics g){
		g.drawImage(background, 0, 0, null);
		
	}
	//��������۷�͵л�
	public void paintFlyingObject(Graphics g){
		for(int i=0;i<flyings.length;i++){
			g.drawImage(flyings[i].image, flyings[i].x, flyings[i].y, null);
		}
	}
	//��Ӣ�ۻ�
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x,hero.y, null);
	}
	//���ӵ�
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}
	//������
	public void paintScore(Graphics g){
		int x = 0;
		int y = 25;
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
		g.setColor(new Color(0,220,0));
		g.drawString("SCORE:"+score, x, y);
		g.drawString("LIFE:"+hero.getLife(), x, y+30);
	}
	//��״̬
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

	//����¼�(��Ҫ�����߼�)�������
	public void action(){
		MouseAdapter mouse = new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
				}
			}
			//����Ƴ�
			public void mouseExited(MouseEvent e){
				if(state==RUNNING)
					state = PAUSE;
			}
			//������
			public void mouseEntered(MouseEvent e){
				if(state==PAUSE)
					state = RUNNING;
			}
			//�����
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
	//�жϳ����¼�
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
	//�����Ϸ�Ƿ����
	public void checkGameoverAction(){
		if(isGameover()){
			state = GAMEOVER;
		}
	}
	//�ж���Ϸ����
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
	//����ӵ������¼�
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			bang(b,i);
		}
	}
	//�жϷ������Ƿ��ӵ��У����к���
	public void bang(Bullet b,int ind){
		int index = -1;
		//�����еķ�����
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].shootBy(b)){
				index = i;
				break;
			}
		}
		if(index!=-1){
			//ɾ���ӵ�
			Bullet bt = bullets[ind];
			bullets[ind] = bullets[bullets.length-1];
			bullets[bullets.length-1] = bt;
			bullets = Arrays.copyOf(bullets, bullets.length-1);
			//ɾ��������
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
	
	//�����ӵ�����
	public void shootAction(){
		shootindex++;
		if(shootindex%30==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	//�������˶��¼�
	public void stepAction(){
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		hero.step();
	}
	//����������¼�
	public void flysEnterAction(){
		flyEnterIndex++;
		if(flyEnterIndex%30==0){
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = obj;
		}
	}
	//С�۷�ĳ��ָ���
	public FlyingObject nextOne(){
		int type = new Random().nextInt(20); 
		if(type == 0)
			return new Bee();
		else
			return new Airplane();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ɻ���ս");
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ShootGame panel = new ShootGame();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel();
		label.setText("��ӭ�����ɻ���ս");
		Font font = new Font("����",Font.BOLD,30);
		label.setFont(font);
		
		panel.add(label);
		frame.add(panel);
		
		panel.action();
		
	}
	
	
	
	
	
	
	
	
	
	
}
