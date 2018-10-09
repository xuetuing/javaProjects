package action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import util.ImgUtil;

public class ImgAction extends BaseAction{
	//�����������ڷ��ظ�Result
	private InputStream is;
	//private String key;

	public String execute(){
		Map<String,BufferedImage> map = ImgUtil.getImage();
		//��ȡkey
		String key = map.keySet().iterator().next();
		//��key ���浽session��
		//ActionContext.getContext().getSession(); //����ֵΪmap,����ʹ������HttpSession�еķ���
		//�̳���BaseAction�е�session
		session.put("rightCode", key);
		BufferedImage img = map.get(key);
		is = ImgUtil.changeImage(img);
		return "success";
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
	
}	
