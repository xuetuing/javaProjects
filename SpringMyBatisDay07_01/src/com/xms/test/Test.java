package com.xms.test;

public class Test {
	
	
	public int test(){
		int x = 1;
		try {
			return x;
		}finally{
			++x;
		}
		
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		
		System.out.println(t.test());
	}
}
