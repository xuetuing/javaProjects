package action;

public class CheckUserCodeAction extends BaseAction{
	private String userCode;
	//�������
	private boolean flag = false;
	public String execute(){
		//�������userCode�뱾�����ɵ�UserCode�Ƚ�
		//��ȡ��ȷ����֤��
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
