package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class UploadAction extends BaseAction{
	private File fi;
	//�ļ����Ƶ�������ʽ�̶�(fi+FileName)
	private String fiFileName;
	public String execute(){
		System.out.println(fi);
		//����ʱ�ļ��µ��ļ����Ƶ�upload�ļ�����
		//�õ�upload�ļ��еľ���·��
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
