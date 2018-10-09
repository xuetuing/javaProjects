package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel{
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");
		frame.setVisible(true);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game panel = new Game();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel();
		label.setText("欢迎来到飞机大战");
		Font font = new Font("宋体",Font.BOLD,30);
		label.setFont(font);
		
		panel.add(label);
		frame.add(panel);
	}
}
