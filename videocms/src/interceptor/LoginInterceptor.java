package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{
	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡsession�б�����û�����
		Map<String,Object> map = ActionContext.getContext().getSession();
		Object obj = map.get("admin");
		if(obj==null){
			return "login";
		}else{
			invocation.invoke();
		}
		
		return null;
	}

}
