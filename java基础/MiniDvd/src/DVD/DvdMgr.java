package DVD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DvdMgr{
	private DvdSet dvd;
	
	public DvdMgr() {
		dvd = new DvdSet();
		this.init();
	}

	public void init(){
		this.dvd.name[0] = "罗马假日";
		this.dvd.name[1] = "风声鹤唳";
		this.dvd.name[2] = "浪漫满屋";
		this.dvd.state[0] = 0;
		this.dvd.state[1] = 1;
		this.dvd.state[2] = 1;
		this.dvd.date[0] = "2013-7-1";
	}
	
	public void add(){
		System.out.print("输入书名->");
		String name = new Scanner(System.in).nextLine();
		for(int i=0;i<dvd.name.length;i++){
			if(dvd.name[i]!=null){
			}else{
				dvd.name[i] = name;
				dvd.state[i] = 1;
				break;
			}
		}
		System.out.println("添加成功.");
	}
	
	public void search(){
		System.out.println("序号\t状态\t书名\t  借出时间");
		for(int i=0;i<dvd.name.length;i++){
			if(dvd.name[i]!=null){
				String name = dvd.name[i];
				String state = dvd.state[i]==0?"已借出":"可借";
				String date = dvd.date[i]==null?"":dvd.date[i];
				System.out.println(i+1+"\t"+state+"\t"+name+"\t  "+date);
			}else{
				break;		
			}
		}
	}
	
	public void delete(){
		System.out.print("输入书名->");
		String name = new Scanner(System.in).nextLine();
		int index = -1;
		for(int i=0;i<dvd.name.length;i++){
			if(name.equals(dvd.name[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			for(int i=index;i<dvd.name.length;i++){
				if(i!=dvd.name.length-1){
					dvd.name[i] = dvd.name[i+1];
					dvd.state[i] = dvd.state[i+1];
					dvd.date[i] = dvd.date[i+1];
				}
			}
		}
		System.out.println("删除成功.");
	}
	public void send(){
		System.out.print("输入书名->");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		for(int i=0;i<dvd.name.length;i++){
			if(dvd.name[i]==null || i==dvd.name.length){
				System.out.println("非本馆藏书.");
				break;
			}
			if(name.equals(dvd.name[i])){
				if(dvd.state[i]==0){
					System.out.println("书籍已被借出，不可借");
					break;
				}
				dvd.state[i] = 0;
				System.out.println("输入借出日期:");
				dvd.date[i] = sc.next();
				break;
			}
		}
	}
	public void giveBack() throws Exception{
		System.out.print("输入书名->");
		String name = new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<dvd.name.length;i++){
			if(dvd.name[i]==null || i==dvd.name.length){
				System.out.println("非本馆藏书.");
			}
			if(name.equals(dvd.name[i])){
				Date date1 = sdf.parse(dvd.date[i]);
				Date date2 = new Date();
				double charge = (date2.getTime()-date1.getTime())/(24*60*60*1000)*3;
				System.out.println("租金为："+charge);
				dvd.state[i] = 1;
				dvd.date[i] = null;
				break;
			}
		}
		System.out.println("还书成功.");
	}
	
}










