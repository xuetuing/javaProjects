package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileAction extends BaseAction{
	//输入属性
	private File some; //文件
	private String someFileName;//文件名称
	
	//输出新的文件名.后缀
	private String newName;
	private String fix;
	
	public String execute(){
		fix = someFileName.substring(someFileName.lastIndexOf(".")+1);
		newName = System.currentTimeMillis()+"";
		//获取目标文件的路径
		String realPath = sc.getRealPath("upload\\"+newName+"."+fix);
		File dest = new File(realPath);
		try {
			FileUtils.copyFile(some,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public File getSome() {
		return some;
	}
	public void setSome(File some) {
		this.some = some;
	}
	
	public String getSomeFileName() {
		return someFileName;
	}

	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}

	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	
	
	
}
