package cn.test.action;

import cn.test.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginActoin extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		// ��ȡActionContext
		ActionContext context = ActionContext.getContext();
		if("admin".equals(user.getUsername())&& "123".equals(user.getPassword())){
			//���û��洢��session��
			context.getSession().put("user", user);
			return SUCCESS;
		}else {
			context.put("msg", "�û������벻��ȷ");
			return INPUT;
		}
		
	}
	

}
