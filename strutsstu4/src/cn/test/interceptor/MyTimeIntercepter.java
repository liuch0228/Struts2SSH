package cn.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyTimeIntercepter extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 1.ִ��Action֮ǰ�Ĺ�������ȡ��ʼִ��ʱ��
		long startTime = System.currentTimeMillis();
		System.out.println("ִ��Action֮ǰ�Ĺ���,��ʼʱ�䣺" + startTime);
		// 2.ִ�к�����������Action
		String result = invocation.invoke();
		// 1.ִ��Action֮��Ĺ��������㲢���ִ��ʱ��
		long endTime = System.currentTimeMillis();

		System.out.println("ִ��Action֮��Ĺ���,����ʱ�䣺" + endTime);
		System.out.println("�ܹ���ʱ��" + (endTime - startTime));
		return result;
	}

}
