package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreatDB {
	
	//��ȡ��䣬ÿ�ζ�ȡһ�У�ֱ�����Ϊֹ
	public String ReadFile() throws IOException{
		FileReader fr = new FileReader("C:/Users/Administrator/Desktop/TBL_AUTHOR.txt");
		BufferedReader br = new BufferedReader(fr);
		String sql = "";
		while(true){
			String str = br.readLine();
			sql += str;
			if(str.endsWith(";"))
				break;
			 
		}
		
		while(true){
			String str = br.readLine();
			if(str.startsWith("insert")){
				
			}
		}
		
	}
	//ִ����䣬Statement
	public void executeSql(){
		
	}
}




















