package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射复制对象
 * @author Administrator
 *
 */
public class ReflectLearn5 {

	public static void main(String[] args) throws Exception {
		Person p = new Person(3,"jack","america");
		Object obj = copyOjbect(p);
		System.out.println(obj);
	}
	
	public static Object copyOjbect(Object obj) throws Exception{
		//获得传递过来的对象的属性和构造器
		Class<? extends Object> class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Constructor constructor = class1.getConstructor();
		Object instance = constructor.newInstance(null);
		for (Field f : fields) {
			//获得属性名字
			String name = f.getName();
			//获得属性类型
			Class<?> type = f.getType();
			//获得属性对应的set方法
			String setMethodName = "set"+ name.substring(0,1).toUpperCase()+name.substring(1);
			String getMethodName = "get"+ name.substring(0,1).toUpperCase()+name.substring(1);
			//获得get方法
			Method gmethod = class1.getDeclaredMethod(getMethodName, null);
			//调用get方法获得被复制对象的一个属性值
			Object gresult = gmethod.invoke(obj, null);
			//get方法的参数类型是string,返回值类型也是
			Method smethod = class1.getDeclaredMethod(setMethodName,type);
//			Method smethod = class1.getDeclaredMethod(setMethodName,gmethod.getReturnType());
			smethod.invoke(instance, gresult);
			
		}
		return instance;
	}
}
