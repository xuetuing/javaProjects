package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Swingͼ�λ�����
public class Demo extends JPanel{
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ɻ���ս");//�������ڶ���
		//frame.setTitle("�ɻ���ս");//���ô��ڱ���
		frame.setSize(600,500);//���ô��ڴ�С
		frame.setVisible(true);//���ÿɼ�
		frame.setLocationRelativeTo(null);//���þ�����ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڹر�ʱ�����˳�
		frame.setAlwaysOnTop(true);//���ô��������ϲ���ʾ
		frame.setResizable(false);//���ô��ڴ�С�̶�
		
		Demo panel = new Demo(); //����������
		panel.setBackground(Color.lightGray);
		
		JLabel label = new JLabel();//������ǩ����
		label.setText("��ӭ�����ɻ���ս");//����ǩ����ı�
		Font font = new Font("����",Font.BOLD,30);//��������������壬���Σ���С��
		label.setFont(font);
		
		panel.add(label);
		frame.add(panel);
		
	}
}






















