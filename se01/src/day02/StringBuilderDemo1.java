package day02;
/*
 * StringBuilder���ַ����Ĳ�����
 * append()  insert()  delete()  replace()
 * ʹ�÷�ʽ��builder.append()
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "�ú�ѧϰPython";
		StringBuilder builder = new StringBuilder(str);
		
		builder.append(",Ϊ���Ҹ��ù���");
		builder.replace(13, builder.length(), "�ı�����");
		builder.delete(0,11);
		builder.insert(0,"����,");
		//builder.replace(2,3,"����");
		builder.delete(2,3);
		builder.insert(2,"����");
		System.out.println(builder);  //builder ��д��toString()����
		
		
		
	}
}
