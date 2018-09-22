package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileAction extends BaseAction{
	//��������
	private File some; //�ļ�
	private String someFileName;//�ļ�����
	
	//����µ��ļ���.��׺
	private String newName;
	private String fix;
	
	public String execute(){
		fix = someFileName.substring(someFileName.lastIndexOf(".")+1);
		newName = System.currentTimeMillis()+"";
		//��ȡĿ���ļ���·��
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
