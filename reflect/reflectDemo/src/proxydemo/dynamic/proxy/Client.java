package proxydemo.dynamic.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		// 创建被代理的接口实现类对象
		 HireHouseImpl hhi = new HireHouseImpl();
		 //创建代理对象:第一个参数是被代理的对象的类加载器，第二个是被代理对象的类的所有接口，第三个参数是自定义代理类的角色
		 HireHouse hh =
		 (HireHouse)Proxy.newProxyInstance(hhi.getClass().getClassLoader(),
		 hhi.getClass().getInterfaces(), new HireProxy(hhi)); //返回被代理对象的接口的实例
		 hh.hire();

		// 给list做代理
//		List list = new ArrayList();
//		List hh1 = (List) Proxy.newProxyInstance(list.getClass()
//				.getClassLoader(), list.getClass().getInterfaces(),
//				new HireProxy(list));
//		hh1.add("张三");
//		hh1.get(0);//被代理对象的所有方法都被代理了

	}
}
