package cn.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyTimeIntercepter extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 1.执行Action之前的工作：获取开始执行时间
		long startTime = System.currentTimeMillis();
		System.out.println("执行Action之前的工作,开始时间：" + startTime);
		// 2.执行后续拦截器或Action
		String result = invocation.invoke();
		// 1.执行Action之后的工作：计算并输出执行时间
		long endTime = System.currentTimeMillis();

		System.out.println("执行Action之后的工作,结束时间：" + endTime);
		System.out.println("总共用时：" + (endTime - startTime));
		return result;
	}

}
