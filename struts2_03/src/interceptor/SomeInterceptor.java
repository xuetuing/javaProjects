package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor implements Interceptor{

	public void destroy() {
		
	}

	public void init() {
		System.out.println("����������...");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("��������Ч...");
		//���ú������
		/*invoke�������ú������ �ҽ�����Ȩ�����������*/
		//arg0.invoke();
		arg0.invokeActionOnly();  //�������ú��������������Ȩ�����Լ�
		return "success2";
	}

}
