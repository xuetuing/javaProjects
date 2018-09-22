package testdemo;

import java.util.*;

public class RoleRight {
	private static Hashtable rightList= new Hashtable();

	/*
	 * 初始化方法，初始化RightList
	 */
	public void init(){
		String[] accRole = {"admin","satrap","manager","user","guest"};
		String[] rightCodeList = {"10001","10011","10021","20011","24011"};
		for(int i=0;i<accRole.length;i++){
			rightList.put(accRole[i],rightCodeList[i]);
		}
	}
	/*
	 * 获得权限值
	 */
	public String getRight(String role){
		if(rightList.containsKey(role))
			return (String)rightList.get(role);
		else
			return null;
	}
	
	
	/*
	 * 增加权限
	 */
	public void insert(String role,String right){
		rightList.put(role,right);
	}
	/*
	 * 修改权限
	 */
	@SuppressWarnings("unchecked")
	public void update(String role,String new_right){
		//rightList.remove(role);
		rightList.put(role,new_right);
	}
	/*
	 * 删除权限
	 */
	public void delete(String role){
		rightList.remove(role);
	}
	/*
	 * 打印权限信息
	 */
	public void print(){
		Enumeration RLKey = rightList.keys();
		while(RLKey.hasMoreElements()){
			String role = RLKey.nextElement().toString();
			print(role+"="+this.getRight(role));
		}
	}
	/*
	 * 打印输出信息
	 */
	public void print(Object obj){
		System.out.println(obj);
	}
}
















