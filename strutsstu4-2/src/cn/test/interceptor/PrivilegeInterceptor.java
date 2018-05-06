package cn.test.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �Զ����������࣬��ȡsession�����޵�½�û������ҳ����ת��Ȩ�޿���
 * 
 * @author Administrator
 * 
 */
public class PrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ��ȡactionContext
		ActionContext actionContext = invocation.getInvocationContext();
		// ��ȡsession�е��û�
		Object user = actionContext.getSession().get("user");
		if (null != user) {
			return invocation.invoke(); // ��������ִ��
		} else {
			actionContext.put("msg", "�Բ�������δ��½��");
			return Action.LOGIN; // �����߼���ͼ��"login",�ɶ�Ӧ��result���ã���ת����½ҳ��
		}
	}

}
