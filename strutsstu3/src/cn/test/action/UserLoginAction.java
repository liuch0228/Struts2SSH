package cn.test.action;

import cn.test.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action�����������-�������� strtus2��ҳ����������ݺ�Action�����ֻ����Ķ�Ӧ��ʽ���ֱ����ֶ�������ģ��������ʽ���ֶ�����Ҳ����������
 * ����������ָͨ�ֶν������ݴ��ݣ�������������������͵����Զ�Ӧ��ֱ��ʹ�������(Ҳ����javaBean)
 * 
 * @author Administrator
 * 
 */
public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;// ͨ��javaBean��ȡǰ�˴��ݵ�����;��������getter setter����

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		//��ȡContext���� ͨ��ActionContext�����Servlet API
		ActionContext context = ActionContext.getContext();
		if("admin".equals(user.getName()) && "123".equals(user.getPassword())){
			//���û���������ŵ�session��
			context.getSession().put("username", user.getName());
			context.getSession().put("password", user.getPassword());
			return Action.SUCCESS;
		} else {
			context.getSession().put("error", "�û���½ʧ��");
			return ERROR;//Action�ӿ��ж���ĳ���
		}
		
	}

	

}
