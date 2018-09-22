package bean;

import java.io.Serializable;

/*该类用于模拟返回给浏览器的一个响应内容主体*/
public class ResponseBody implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;//状态码
	private String msg;//描述信息
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
