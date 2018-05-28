import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDeom1 {

	public static void main(String[] args) throws Exception {
		// List<?> list = new ArrayList();  //<?>中的问号为泛型，表示不知道后面list对象中存放的实际类型是什么，用？表示
		Class<?> class1 = Class.forName("cn.tx.Person");
		// 获取名字为address 的这个属性
		Field field = class1.getDeclaredField("address");
		System.out.println("获取到的属性值的全路径名是：" + field);
		// 动态获取属性并设置值：先获取对象，然后再设置属性值
		// 获取方法：方法没有参数的
		Method method = class1.getDeclaredMethod("getName", new Class[] {});
		System.out.println(method);
		Method method2 = class1.getDeclaredMethod("setName",
				new Class[] { String.class });
		System.out.println(method2);
		// 获得无参构造器
		Constructor<?> constructor = class1
				.getDeclaredConstructor(new Class[] {});
		// System.out.println(constructor);

		Constructor<?> constructor2 = class1
				.getDeclaredConstructor(new Class[] { Integer.class,
						String.class, String.class });
		// System.out.println(constructor2);

		// 根据类的默认构造器获取对象
		Object instance = constructor.newInstance(new Object[] {});
		System.out.println(instance.toString());// 说明获取到的就是person
		// 根据有参构造获取对象
		Object instance2 = constructor2.newInstance(new Object[] { 1, "李四",
				"北京" });
		System.out.println(instance2);

	}

}
