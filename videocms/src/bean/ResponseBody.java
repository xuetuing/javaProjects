package bean;

import java.io.Serializable;

/*��������ģ�ⷵ�ظ��������һ����Ӧ��������*/
public class ResponseBody implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;//״̬��
	private String msg;//������Ϣ
	private Object obj;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
}
