package proxydemo.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理必须实现InvocationHandler接口，通过反射去调用被代理的接口
 * @author Administrator
 * 
 */
public class HireProxy implements InvocationHandler {
	// 被代理的真实角色
	private Object obj;// 真实角色，要给任何对象做代理，只能是持有Object类型的对象
	
	public HireProxy(Object obj) {
		super();
		this.obj = obj;
	}

/**
 * jdk动态代理，被代理对象必须实现接口
 * 被代理的对象必然实现共同的Hire接口，那么就有方法
 * method:被代理的对象的接口中的方法，要调用方法，必须有对象，此处这个对象就是被代理对象，因此必须要指定被代理的对象
 * args是被代理对象接口的方法的参数，通过反射调用invoke方法的参数proxy对象的method方法
 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("前置工作");
//		for (Object object : args) {
//			System.out.print("invoke方法中的第三个参数："+object +" ");//给list做代理时测试用
//		}
		Object invoke = method.invoke(obj, args);
		System.out.println("\n后置工作");
		return invoke;
	}

}
