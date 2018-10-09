package action;

import entity.User;

public class LoginAction2 {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(){
		if("zs".equals(user.getUsername())&&"1234".equals(user.getPassword())){
			return "success";
		}else{
			return "error";
		}
	}
}
