package cn.test.action;

import cn.test.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action处理请求参数-属性驱动 strtus2中页面的请求数据和Action有两种基本的对应方式，分别是字段驱动和模型驱动方式。字段驱动也叫属性驱动
 * 属性驱动是指通字段进行数据传递，包括：与基本数据类型的属性对应，直接使用域对象(也就是javaBean)
 * 
 * @author Administrator
 * 
 */
public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;// 通过javaBean获取前端传递的数据;必须设置getter setter方法

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		//获取Context对象： 通过ActionContext类访问Servlet API
		ActionContext context = ActionContext.getContext();
		if("admin".equals(user.getName()) && "123".equals(user.getPassword())){
			//把用户名和密码放到session中
			context.getSession().put("username", user.getName());
			context.getSession().put("password", user.getPassword());
			return Action.SUCCESS;
		} else {
			context.getSession().put("error", "用户登陆失败");
			return ERROR;//Action接口中定义的常量
		}
		
	}

	

}
