package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Swing图形化界面
public class Demo extends JPanel{
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战");//创建窗口对象
		//frame.setTitle("飞机大战");//设置窗口标题
		frame.setSize(600,500);//设置窗口大小
		frame.setVisible(true);//设置可见
		frame.setLocationRelativeTo(null);//设置居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭时程序退出
		frame.setAlwaysOnTop(true);//设置窗口在最上层显示
		frame.setResizable(false);//设置窗口大小固定
		
		Demo panel = new Demo(); //创建面板对象
		panel.setBackground(Color.lightGray);
		
		JLabel label = new JLabel();//窗机标签对象
		label.setText("欢迎来到飞机大战");//给标签设计文本
		Font font = new Font("宋体",Font.BOLD,30);//创建字体对象，字体，字形，大小、
		label.setFont(font);
		
		panel.add(label);
		frame.add(panel);
		
	}
}






















