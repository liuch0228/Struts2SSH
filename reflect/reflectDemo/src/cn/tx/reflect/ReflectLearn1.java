package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * 一、反射获取类的属性，方法，构造器
 * @author Administrator
 *
 */
public class ReflectLearn1 {
	
	private static String className = "java.lang.String";
	public static void main(String[] args) throws Exception {
		// <?>中的问号为泛型，表示不知道后面list对象 中存放的实际类型是什么，用？表示
		// List<?> list = new ArrayList();

		// 1.根据一个类的全路径名获取一个类的类对象:Class对象
		
		Class<?> clazz = Class.forName(className);

		// 2.获得传递过来的类(上面的String类)的所有方法——目的就是为了调用获得的方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}

		// 3.获得类的所有声明的属性——目的：设置属性或者是获取属性值，或者是获取属性上的注解！
		System.out.println("-------------获得类的所有声明的属性---------------");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}

		// 4.获得类的所有构造器——创建对象
		System.out.println("--------------获得类的所有构造器--------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		//5.获取一个类的Class对象的三种方式：
		//(1)知道类的全路径名，Class<?> clazz = Class.forName("类的全路径名");
		//(2)知道该类的一个对象   Class<?> clazz = 对象名.getClass();
		//(3)
		System.out.println("----------获取Person类的信息-------------");
		Person p = new Person();
		test(p);
		/*	test(p);打印结果如下
		 * 	----------获取Person类的信息-------------
			public java.lang.String cn.tx.Person.toString()
			public java.lang.String cn.tx.Person.getAddress()
			public java.lang.String cn.tx.Person.getName()
			public java.lang.Integer cn.tx.Person.getId()
			public void cn.tx.Person.setName(java.lang.String)
			public void cn.tx.Person.setId(java.lang.Integer)
			public void cn.tx.Person.setAddress(java.lang.String)
			-------------获得类的所有声明的属性---------------
			private java.lang.Integer cn.tx.Person.id
			private java.lang.String cn.tx.Person.name
			private java.lang.String cn.tx.Person.address
			--------------获得类的所有构造器--------------
			public cn.tx.Person()
			public cn.tx.Person(java.lang.Integer,java.lang.String,java.lang.String)
		 * */
		//(3)
		

	}
	
	/**
	 * Class<? extends Object> 
	 * @param obj
	 */
	public static void test(Object obj){
		//Class<? extends Object>表示通过反射获取的对象的类型不确定，但是一定是Object类的子类
		//等价于Class<?> clazz = obj.getClass();
		Class<? extends Object> clazz = obj.getClass();
		// 2.获得传递过来的类(上面的String类)的所有方法——目的就是为了调用获得的方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}

		// 3.获得类的所有声明的属性——目的：设置属性或者是获取属性值
		System.out.println("-------------获得类的所有声明的属性---------------");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}

		// 4.获得类的所有构造器——创建对象
		System.out.println("--------------获得类的所有构造器--------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}

}
