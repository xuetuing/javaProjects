package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		//ȡsession�е�admin
		Map<String,Object> map = ActionContext.getContext().getSession();
		Object obj = map.get("admin");
		if(obj==null){
			//δ��¼
			return "login";
		}else{
			arg0.invoke();
		}
		
		return null;
	}

}
