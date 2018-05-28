package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * 二、获取一个类的Class对象的三种方式：
		(1)知道类的全路径名：Class<?> clazz = Class.forName("类的全路径名");
		(2)知道类的名字：  Class<?> clazz = 类名.class;
		(3)知道该类的一个对象 ：  Class<?> clazz = 对象名.getClass();
 * @author Administrator
 *
 */
public class ReflectLearn2 {
	
	private static String className = "java.lang.String";
	public static void main(String[] args) throws Exception {
		
		//根据类的名字获取类的Class对象
		getClazzByClassName();
		//根据对象获取Class对象，反射获取类的方法，属性，构造器
		getCalzzByObject(new Person());
	}
	
	public static void getClazzByClassName(){
		Class<?> clazz = Person.class;//类名.class获取类的Class对象
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
	}
	
	/**
	 * 根据类的对象获取Class对象
	 * @param obj
	 */
	public static void getCalzzByObject(Object obj){
		//Class<? extends Object>表示通过反射获取的对象的类型不确定，但是一定是Object类的子类
		//等价于Class<?> clazz = obj.getClass();
		Class<? extends Object> clazz = obj.getClass();
		// 2.获得传递过来的类(上面的String类)的所有方法——目的就是为了调用获得的方法
		System.out.println("----------------获取类的所有声明的方法-------------------");
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
		System.out.println("--------------获得类的所有构造器-----------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}

}
/*	getCalzzByObject(new Person());打印结果如下
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
