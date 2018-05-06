package cn.test.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器类，获取session中有无登陆用户，完成页面跳转的权限控制
 * 
 * @author Administrator
 * 
 */
public class PrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取actionContext
		ActionContext actionContext = invocation.getInvocationContext();
		// 获取session中的用户
		Object user = actionContext.getSession().get("user");
		if (null != user) {
			return invocation.invoke(); // 继续向下执行
		} else {
			actionContext.put("msg", "对不起，您还未登陆！");
			return Action.LOGIN; // 返回逻辑视图名"login",由对应的result配置，跳转到登陆页面
		}
	}

}
