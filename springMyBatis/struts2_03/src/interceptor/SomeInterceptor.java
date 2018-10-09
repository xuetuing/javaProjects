package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor implements Interceptor{

	public void destroy() {
		
	}

	public void init() {
		System.out.println("拦截器创建...");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截器生效...");
		//调用后续组件
		/*invoke方法调用后续组件 且将发言权交给后续组件*/
		//arg0.invoke();
		arg0.invokeActionOnly();  //仅仅调用后续组件，但发言权还在自己
		return "success2";
	}

}
