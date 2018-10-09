package day02;

public class CellDemo {
	public static void main(String[] args){
		Cell c1;     //外部文件类使用
		c1 = new Cell();
		Cell c2 = new Cell();
		c1.row = 2;
		c1.col = 3;
		c2.row = 2;
		c2.col = 5;
		System.out.println(c1.row);
		c1.drop();
		System.out.println(c1.row);
		c1.drop(3);
		System.out.println(c1.row);
	}
}
