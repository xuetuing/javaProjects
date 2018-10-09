package action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import entity.Admin;

import service.LoginService;
import util.ImgUtil;
import bean.ResponseBody;

public class LoginAction extends BaseAction{
	LoginService ls = new LoginService();
	//输入属性
	private boolean flag = false;
	private String userCode;  
	private String username;
	private String password;
	//输出属性
	private InputStream is;
	private ResponseBody body;
	
	public String getCodeImg(){
		//获取验证码map
		Map<String,BufferedImage> map = ImgUtil.getImage();
		//获取验证码
		String rightCode = map.keySet().iterator().next();
		session.put("rightCode", rightCode);
		//获取验证码图片
		BufferedImage img = map.get(rightCode);
		is = ImgUtil.changeImage(img);
		
		return "success";
	}
	public String checkUserCode(){
		String rightCode = (String)session.get("rightCode");
		System.out.println(userCode);
		body = new ResponseBody();
		if(!userCode.equalsIgnoreCase(rightCode)){
			body.setCode("1");
			body.setMsg("验证码不正确");
			body.setObj(flag);
			return "error";
		}
		flag = true;
		body.setCode("000");
		body.setMsg("验证码正确");
		body.setObj(flag);
		return "success";
	}
	public String login(){
		try {
			Admin admin = ls.findByUsername(username);
			body = new ResponseBody();
			if(admin==null){
				body.setCode("1");
				body.setMsg("用户名不存在");
				return "error";
			}else{
				if(!password.equals(admin.getPassword())){
					body.setCode("2");
					body.setMsg("密码不正确");
					return "error";
				}
				//登录成功
				body.setCode("000");
				body.setMsg("登录成功");
				session.put("admin",admin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUserCode() {
		return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public ResponseBody getBody() {
		return body;
	}

	public void setBody(ResponseBody body) {
		this.body = body;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
