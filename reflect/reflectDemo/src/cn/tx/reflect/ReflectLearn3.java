package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * 三 、Class类中要掌握的方法：
 * 反射获取具体属性、方法、构造器
 * @author Administrator
 *
 */
public class ReflectLearn3 {
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = Class.forName("cn.tx.Person");
		//1.反射获取类的属性值
		Field field = clazz.getDeclaredField("address");
		System.out.println("反射获取到的类的属性信息为：" + field);
		//打印结果： 反射获取到的类的属性信息为：private java.lang.String cn.tx.Person.address
		//设置属性：首先获取对象
		
		//2.反射获取方法：必须指定要获取的方法名和该方法的返回值类型，只靠方法名是不行的，还需要知道方法参数列表中的参数类型
		/*Method java.lang.Class.getDeclaredMethod(String name, Class<?>... parameterTypes) 
		 *Class<?>... 是可变参数，表示一个元素个数不确定的Class数组 */
		//Person类的getName()方法，没有形参，Class数组写new Class[]{}
		Method method = clazz.getDeclaredMethod("getName", new Class[]{});
		System.out.println("获取到的getName()方法："+method);//获取到的getName()方法：public java.lang.String cn.tx.Person.getName()
		Method method2 = clazz.getDeclaredMethod("setName", new Class[]{String.class}); //setName方法有一个String类型的形参
		System.out.println("获取到的setName()方法："+method2);//获取到的getName()方法：public java.lang.String cn.tx.Person.getName()
		
		//3.反射获取无参构造器Constructor<?> java.lang.Class.getDeclaredConstructor(Class<?>... parameterTypes) 
		Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{}); //参数为类的类对象数组
		System.out.println(constructor); //打印public cn.tx.Person()
		Constructor<?> constructor2 = clazz.getDeclaredConstructor(new Class[]{Integer.class,String.class,String.class});
		System.out.println(constructor2); //public cn.tx.Person(java.lang.Integer,java.lang.String,java.lang.String)
		
		//4.使用构造器创建对象: Constructor类的public T newInstance(Object ... initargs)
		Object object = constructor.newInstance(new Object[]{});
		System.out.println(object); //Person [address=null, id=null, name=null]
//		Object object2 = constructor.newInstance(new Object[]{1,"李四","北京"});
		Object object2 = constructor2.newInstance(1,"李四","北京"); 
		System.out.println(object2);//Person [address=北京, id=1, name=李四]
		
		//5.设置属性
		//获得类的所有方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			//获得方法的名字;
			String name = m.getName(); // 在这一行打断点，F6单步调试，查看反射掉调用过程
			if(name.startsWith("set")){
				//获得set字符串后面的值
				String fieldName = name.substring(3);
				//获得属性名
				fieldName = fieldName.substring(0,1).toLowerCase()+ fieldName.substring(1);
				//获得方法对应的属性
				Field field2 = clazz.getDeclaredField(fieldName);//注意，不是getField()
				//获得属性对应的具体类型
				Class<?> type = field2.getType();
				if(type == Integer.class){
					//通过method对象反射调用Person类的方法，第一个参数是调用方法的对象，第二个参数是方法的实参值
					m.invoke(object2, 2); //相当于person.setId(2)
				}
				if(type == String.class && "address".equals(fieldName)){
					m.invoke(object2, "南京");
				}
				if(type == String.class && "name".equals(fieldName)){
					m.invoke(object2, "tom");
				}
			}
		}
		
		//6.直接设置属性：field.setAccessible(true)
		Field field2 = clazz.getDeclaredField("name");
		field2.setAccessible(true);//让私有的属性可以被访问
		field2.set(object2, "marry");
		System.out.println(object2);
		
		
		
		
	
	}
}
