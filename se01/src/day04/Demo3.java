package day04;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * ��������Ԫ��ͨ�÷�ʽ��������ģʽ
 */
public class Demo3 {
	public static void main(String[] args) {
		Collection c = new LinkedList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add(null);
		
		/*
		 * Iterator��һ���ӿ�
		 * ��ͬ�ļ��Ϸ��صĵ�����ʵ�ֵĲ�����ͬ
		 */
		Iterator it = c.iterator();
		System.out.println(it);
		/*
		 * ע�⣺ʹ�õ������������ϵ�˳�������ѭ����ȡɾ��ɾ�����Ǳ���ģ�
		 * �ʣ�boolean hasnext():�鿴��ǰ�����Ƿ���Ԫ�ؿ��Ա���
		 * ȡ��Object next():ȡ��һ��Ԫ��
		 * ɾ��void remove():ɾ��ͨ��next()������������Ԫ��
		 */
		while(it.hasNext()){
			Object obj = it.next();
//			if(obj.equals("#")){  //�ڱ�����"null"ʱ�����ֿ�ָ���쳣��ԭ����equals()
//				it.remove();
//			}
			if("#".equals(obj)){ //��ȷд��
				it.remove();
			}
			//it.remove();//remove()��ÿ�ε���next()������ֻ�ܵ���һ��
			//it.remove();
			//c.remove(obj);������Ҫ���ڵ��������в�����ͨ������ɾ��Ԫ��
			System.out.println(obj);
		}
		System.out.println(c);
		
	}
}









































