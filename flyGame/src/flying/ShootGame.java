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

//JPanel�д��ڷ����л�����д����־��桿
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
	
	int interval = 15;//���ʱ��
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
	//����ͼƬ
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
	
	//��ͼƬ��ӽ���壬
	public void paint(Graphics g){
		paintBackground(g);
		paintHero(g);
		paintBullets(g);
		paintFlyingObject(g);
		paintScore(g);
		paintState(g);
	}
	//������
	public void paintBackground(Graphics g){
		g.drawImage(background,0,0,null);
	}
	//���ӵ��ķ���
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			g.drawImage(bullets[i].image,bullets[i].x,bullets[i].y,null);
		}
	}
	//��������ķ���
	public void paintFlyingObject(Graphics g){
		for(int i=0;i<flyings.length;i++){
			g.drawImage(flyings[i].image,flyings[i].x,flyings[i].y,null);
		}
	}
	//��Ӣ�ۻ��ķ���
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	//����������
	public void paintScore(Graphics g){
		int x = 0;
		int y = 25;
//		Font font = new Font(Font.SANS_SERIF,Font.BOLD,25);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		g.setColor(new Color(0,220,0));
		g.drawString("SCORE:"+score,x,y);
		g.drawString("LIFE:"+hero.getLife(),x,y+30);
	}
	//��״̬
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
	
	//�¼�����Ҫ�Ķ����߼���
	public void action(){
		MouseAdapter ma = new MouseAdapter(){
			//����ƶ�
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x,y);
				}
			}
			//�����
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
			//����Ƴ��¼�
			 public void mouseExited(MouseEvent e){
				 if(state == RUNNING){
					 state = PAUSE;
				 }
			 }
			 //�������
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
		//����
		
		timer1.schedule(new TimerTask(){
			public void run(){
//				if(state == RUNNING){
//					enterAction();   //���������
//					stepAction();	//��������ӵ����˶�
//					shootAction();	//�ӵ�����
//					bangAction();	//��ײ�¼�
//					outOfBoundsAction();	//����
//					checkGameOverAction();	//��Ϸ����
//				}
//				repaint();//����ˢ��+
				addSpeed();
				if(score>50){
					timer1.cancel();
					timer2.schedule(new TimerTask(){
						@Override
						public void run() {
//							if(state == RUNNING){
//								enterAction();   //���������
//								stepAction();	//��������ӵ����˶�
//								shootAction();	//�ӵ�����
//								bangAction();	//��ײ�¼�
//								outOfBoundsAction();	//����
//								checkGameOverAction();	//��Ϸ����
//							}
//							repaint();//����ˢ��+
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
//					enterAction();   //���������
//					stepAction();	//��������ӵ����˶�
//					shootAction();	//�ӵ�����
//					bangAction();	//��ײ�¼�
//					outOfBoundsAction();	//����
//					checkGameOverAction();	//��Ϸ����
//				}
//				repaint();//����ˢ��+
//			}
//		}
//		timer1.schedule(new Task(){
//			if(score>50){
//				timer1.cancel();
//			}
//		}, interval, interval);
		
			
	}
	//��Ϸ����
	public void addSpeed(){
		if(state == RUNNING){
			enterAction();   //���������
			stepAction();	//��������ӵ����˶�
			shootAction();	//�ӵ�����
			bangAction();	//��ײ�¼�
			outOfBoundsAction();	//����
			checkGameOverAction();	//��Ϸ����
		}
		repaint();//����ˢ��+
	}

	//�жϷ���������¼�
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
	//�����Ϸ�����¼�
	public void checkGameOverAction(){
		if(isGameOver()){
			state = GAMEOVER;
		}
	}
	//�ж���Ϸ����
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
	//�����¼�
	public void bangAction(){
		//int inb = -1;
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			//inb = i;
			//bang(b,inb);
			bang(b,i);
		}
	}
	//�ж��ӵ��Ƿ���з�����
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
			bullets = Arrays.copyOf(bullets, bullets.length-1);	 //ɾ���ӵ�
			
			FlyingObject one = flyings[index];
			//FlyingObject f = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = one;
			flyings = Arrays.copyOf(flyings, flyings.length-1);//ɾ��������
			
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
	//�����¼�
	public void shootAction(){
		shootIndex++;
		if(shootIndex%30==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	//��������ӵ����˶��¼�
	public void stepAction(){
		//��������˶�
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		//�ӵ����˶�
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		//Ӣ�ۻ����˶�
		hero.step();
	}
	
	//����������¼�
	public void enterAction(){
		flyEnteredIndex++;
		if(flyEnteredIndex%60==0){
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings,flyings.length+1);
			flyings[flyings.length-1] = obj;
		}
	}
	//���ֵл���С�۷���ֵĸ��ʣ�������в��������
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
		JFrame frame = new JFrame("�ɻ���ս");//�������ڶ���
		ShootGame panel = new ShootGame();
		panel.setBackground(Color.lightGray);
		frame.add(panel);
		
		frame.setSize(WIDTH,HEIGHT);//���ô��ڴ�С
		frame.setResizable(false);//���ô��ڴ�С�̶�
		frame.setAlwaysOnTop(true);//���ô��������ϲ���ʾ
		
		frame.setVisible(true);//���ÿɼ�
		frame.setLocationRelativeTo(null);//���þ�����ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڹر�ʱ�����˳�
		
		JLabel label = new JLabel();//������ǩ����
		label.setText("��ӭ�����ɻ���ս");//����ǩ����ı�
		Font font = new Font("����",Font.BOLD,30);//��������������壬���Σ���С��
		label.setFont(font);
		panel.add(label);
		
		panel.action();
	}
	
}
