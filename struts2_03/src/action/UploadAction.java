package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class UploadAction extends BaseAction{
	private File fi;
	//文件名称的命名方式固定(fi+FileName)
	private String fiFileName;
	public String execute(){
		System.out.println(fi);
		//将临时文件下的文件复制到upload文件夹下
		//拿到upload文件夹的绝对路径
		String path = sc.getRealPath("upload");
		String realPath = path + "\\" + fiFileName;
		File dest = new File(realPath);
		try {
			FileUtils.copyFile(fi,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public File getFi() {
		return fi;
	}
	public void setFi(File fi) {
		this.fi = fi;
	}
	public String getFiFileName() {
		return fiFileName;
	}
	public void setFiFileName(String fiFileName) {
		this.fiFileName = fiFileName;
	}

	
	
}
