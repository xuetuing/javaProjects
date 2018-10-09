package action;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class LoginAction extends BaseAction{
	private String username;
	private String password;
	
	//�����Ϣ
	private String msg;
	
	public String execute(){
		//�����û������û�
		AdminDAO dao = new AdminDAOImpl();
		try {
			Admin admin = dao.findByUsername(username);
			if(admin==null){
				msg = "�û���������";
				return "error";
			}else{
				if(!password.equals(admin.getPassword())){
					msg = "���벻��ȷ";
					return "error";
				}
				//�û���¼�ɹ�
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
