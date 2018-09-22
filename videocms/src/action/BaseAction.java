package action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;


public class BaseAction implements ServletContextAware,SessionAware{
	protected ServletContext sc;
	protected Map<String,Object> session;
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
}
