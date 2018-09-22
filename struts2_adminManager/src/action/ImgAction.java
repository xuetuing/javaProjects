package action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import util.ImgUtil;

public class ImgAction extends BaseAction{
	//输入流，用于返回给Result
	private InputStream is;
	//private String key;

	public String execute(){
		Map<String,BufferedImage> map = ImgUtil.getImage();
		//获取key
		String key = map.keySet().iterator().next();
		//将key 保存到session中
		//ActionContext.getContext().getSession(); //返回值为map,不能使用类似HttpSession中的方法
		//继承自BaseAction中的session
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
