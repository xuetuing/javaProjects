package day05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo2 {
	public static void main(String[] args) {
		String line = "123,345,123,567,234,123,345,789";
		//统计当前字符串每一组数字出现的次数
		String[] s = line.split(",");
		System.out.println(Arrays.toString(s));
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for(String str : s){
			if(map.containsKey(str)){
				int count = map.get(str);
				map.put(str, ++count);
			}else{
				map.put(str,1);
			}
		}
		System.out.println(map);
//		for(int i=0;i<s.length;i++){
//			int count = 1;
//			if(map.containsKey(s[i])){
//				continue;
//			}
//			map.put(s[i], count);
//			for(int j=1;j<s.length-i;j++){
//				if(s[i].equals(s[j])){
//					map.put(s[i], ++count);
//				}
//			}
//		}
//		System.out.println(map);
		
		
	}
}
