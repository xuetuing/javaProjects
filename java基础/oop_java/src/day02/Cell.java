package day02;
public class Cell{  //������
	int row;
	int col;
	//�ø�������ķ���
	public void drop(){
		row++;   //�㷨
	}
	public void drop(int step){
		int row = 8;   //�ֲ�����
		this.row += step;  //this.row��ʵ��������this�Ǿֲ�����
		this.drop();  //�໥����
	}
	public void moveRight(){
		col++;
	}
	public void moveRige(int step){
		col += step;
	}
}












