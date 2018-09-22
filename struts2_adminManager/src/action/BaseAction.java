package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
//实现的是struts2提供的接口属于interceptor
public class BaseAction implements SessionAware{
	protected Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
}
