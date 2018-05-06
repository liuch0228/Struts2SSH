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
		// 获取ActionContext
		ActionContext context = ActionContext.getContext();
		if("admin".equals(user.getUsername())&& "123".equals(user.getPassword())){
			//把用户存储在session中
			context.getSession().put("user", user);
			return SUCCESS;
		}else {
			context.put("msg", "用户名密码不正确");
			return INPUT;
		}
		
	}
	

}
