package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.junit.Test;

import entity.Foo;

public class Test1 {
	@Test
	public void say(){
		System.out.println("a");
	}
	
	@Test
	public void testOgnl() throws OgnlException{
		//���ԺͶ���
		Foo f = new Foo();
		f.setId(1);
		f.setName("java");
		f.setArray(new String[]{"one","two","three"});
		f.setList(Arrays.asList("A","B","C"));
		Map<String,String> map = new HashMap<String,String>();
		map.put("one", "java");
		map.put("two", "python");
		map.put("three", "javajava");
		f.setMap(map);
		
		//ʹ��Ognl���ʽ��ȡֵ
		System.out.println("====��������====");
		Object id = Ognl.getValue("id", f);
		Object name = Ognl.getValue("name", f);
		System.out.println(id+","+name);
		
		System.out.println("====����,List����====");
		Object array0 = Ognl.getValue("array[0]", f);
		Object list0 = Ognl.getValue("list[0]", f);
		System.out.println(array0+","+list0);
		
		System.out.println("====Map����:����.key/����[key]====");
		Object map0 = Ognl.getValue("map.one", f);
		Object map1 = Ognl.getValue("map['one']", f);
		System.out.println(map0+","+map1);
		
		//���÷���
		System.out.println(Ognl.getValue("name.toUpperCase()", f));
		System.out.println(Ognl.getValue("list.size()", f));
		System.out.println(Ognl.getValue("map.three.lastIndexOf(name)", f));
		
		//����map����
		Object obj = Ognl.getValue("#{1:'java',2:'python',3:'javajava'}", null);
		System.out.println(obj.getClass().getName());
		
		//ȡֵʱ�Ӳ�ͬ�����ȡ
		//�Զ���Context����
		Map ctx = new HashMap();
		ctx.put("name","rose");
		
		//root
		Foo f2 = new Foo();
		f2.setName("lucy");
		
		//����# ��ʾ��ҵ�����root Foo�л�ȡ
		System.out.println(Ognl.getValue("name", f2));
		//��# ��ʾ�ӹ�������context�л�ȡ
		System.out.println(Ognl.getValue("#name", ctx, f2));
	
	}
}










