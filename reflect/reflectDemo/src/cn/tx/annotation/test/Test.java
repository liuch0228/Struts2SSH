package cn.tx.annotation.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import cn.tx.annotation.AnnoTest;
import cn.tx.annotation.enums.HttpMethod;

/**
 * 常用的表示性注解：@Test @Override @SuppressWarnings
 * 
 * @author Administrator
 * 
 */
public class Test {

	@org.junit.Test
	public void test() {

	}

	// @AnnoTest(value = "tst")
	@Deprecated
	// 过时，不建议使用的注解
	public void method() {

	}

	/**
	 * @SuppressWarnings压制警告的注解 unchecked 不检查操作时的警告 rawtypes
	 *                          原始类型，也就是不使用泛型，在定义的时候压制泛型的警告
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public void method1() {
		@SuppressWarnings("unused")
		List list = new ArrayList();// 不写泛型类型时，会出现黄色波浪线警告！
		list.add("lisi");
	}

	@org.junit.Test
//	@AnnoTest(value = "test", location = { String.class }, method = HttpMethod.GET)
	// 非标识性注解的意义在于方法被反射调用时
	public void method3() {

	}

	@org.junit.Test
	public void testEnum() {
		System.out.println(HttpMethod.GET);
	}
	
	@org.junit.Test
	public void testAdd(){
		new Caculate().add(3, 5); //正常调用，add方法上面的注解不会起作用
	}

	@org.junit.Test
	public void testAdd1(){
		Class<?> clazz = Caculate.class;
		try {
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("add", int.class,int.class);
			//判断一个方法上面是否存在某个注解
			boolean isPres = method.isAnnotationPresent(AnnoTest.class);
			if(isPres){
				//根据一个类获取注解
				AnnoTest annotation = method.getAnnotation(AnnoTest.class);
				//获得注解上的值
				String value = annotation.value();
				//反射的方式调用add()方法
				Object result = method.invoke(obj, 2,3);
				System.out.println(value+result); //控制台输出 ：  相加的结果是：5
				//如果注解上的@Retention(value = RetentionPolicy.SOURCE),运行时时不会有结果的
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
