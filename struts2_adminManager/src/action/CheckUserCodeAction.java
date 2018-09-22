package action;

public class CheckUserCodeAction extends BaseAction{
	private String userCode;
	//输出属性
	private boolean flag = false;
	public String execute(){
		//将传入的userCode与本次生成的UserCode比较
		//获取正确的验证码
		String rightCode = (String)session.get("rightCode");
		if(rightCode.equalsIgnoreCase(userCode)){
			flag = true;
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
	
}
