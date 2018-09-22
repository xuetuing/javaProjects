package action;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class LoginAction extends BaseAction{
	private String username;
	private String password;
	
	//输出信息
	private String msg;
	
	public String execute(){
		//根据用户名找用户
		AdminDAO dao = new AdminDAOImpl();
		try {
			Admin admin = dao.findByUsername(username);
			if(admin==null){
				msg = "用户名不存在";
				return "error";
			}else{
				if(!password.equals(admin.getPassword())){
					msg = "密码不正确";
					return "error";
				}
				//用户登录成功
				session.put("admin",admin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
