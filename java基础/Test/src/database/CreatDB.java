package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreatDB {
	
	//读取语句，每次读取一行，直到封号为止
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
	//执行语句，Statement
	public void executeSql(){
		
	}
}




















