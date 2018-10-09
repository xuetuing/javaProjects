package testdemo;

import java.util.*;

public class RoleRight {
	private static Hashtable rightList= new Hashtable();

	/*
	 * ��ʼ����������ʼ��RightList
	 */
	public void init(){
		String[] accRole = {"admin","satrap","manager","user","guest"};
		String[] rightCodeList = {"10001","10011","10021","20011","24011"};
		for(int i=0;i<accRole.length;i++){
			rightList.put(accRole[i],rightCodeList[i]);
		}
	}
	/*
	 * ���Ȩ��ֵ
	 */
	public String getRight(String role){
		if(rightList.containsKey(role))
			return (String)rightList.get(role);
		else
			return null;
	}
	
	
	/*
	 * ����Ȩ��
	 */
	public void insert(String role,String right){
		rightList.put(role,right);
	}
	/*
	 * �޸�Ȩ��
	 */
	@SuppressWarnings("unchecked")
	public void update(String role,String new_right){
		//rightList.remove(role);
		rightList.put(role,new_right);
	}
	/*
	 * ɾ��Ȩ��
	 */
	public void delete(String role){
		rightList.remove(role);
	}
	/*
	 * ��ӡȨ����Ϣ
	 */
	public void print(){
		Enumeration RLKey = rightList.keys();
		while(RLKey.hasMoreElements()){
			String role = RLKey.nextElement().toString();
			print(role+"="+this.getRight(role));
		}
	}
	/*
	 * ��ӡ�����Ϣ
	 */
	public void print(Object obj){
		System.out.println(obj);
	}
}
















