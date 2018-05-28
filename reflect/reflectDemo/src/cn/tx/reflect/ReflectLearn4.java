package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射调用方法
 * Object java.lang.reflect.Method.invoke(Object obj, Object... args)
 * 如果底层方法是实例方法，第一个参数就是该实例对象，第二个参数是方法的参数列表，invoke的返回值就是实例方法的返回值
 * 如果底层方法是静态的，那么可以忽略指定的obj参数，可以为null
 * 如果底层方法所需的形参为0，则所提供的args数组长度可以为0或null(参见后面的method2.invoke(object))
 * @author Administrator
 * 
 */
public class ReflectLearn4 {
	public static void main(String[] args) throws Exception {

		Class<?> clazz = Class.forName("cn.tx.Person");
		//获取cn.tx.Person类的无参构造
		Constructor<?> constructor = clazz.getConstructor();
		//获取一个实例
		Object object = constructor.newInstance();
		
		//反射调用setName()方法：method.invoke，返回的就是调用的方法的返回值
		Method method = clazz.getDeclaredMethod("setName", String.class);
		Object invoke = method.invoke(object, "james");//set方法，没有返回值，此处invoke是 null
		System.out.println(object.toString()); //Person [address=null, id=null, name=james]
		
		//反射调用getName()方法
		Method method2 = clazz.getDeclaredMethod("getName");
		Object invoke2 = method2.invoke(object);
		System.out.println(invoke2);
		
		//反射调用静态方法
		Method method3 = clazz.getDeclaredMethod("printInfo",null); //printInfo方法没有参数，写null 
		method3.invoke(null,null);//静态方法，第一个参数可以为null
	
	}

}
