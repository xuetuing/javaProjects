package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
//ʵ�ֵ���struts2�ṩ�Ľӿ�����interceptor
public class BaseAction implements SessionAware{
	protected Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
}
