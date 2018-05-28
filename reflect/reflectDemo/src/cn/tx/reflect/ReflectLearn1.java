package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * һ�������ȡ������ԣ�������������
 * @author Administrator
 *
 */
public class ReflectLearn1 {
	
	private static String className = "java.lang.String";
	public static void main(String[] args) throws Exception {
		// <?>�е��ʺ�Ϊ���ͣ���ʾ��֪������list���� �д�ŵ�ʵ��������ʲô���ã���ʾ
		// List<?> list = new ArrayList();

		// 1.����һ�����ȫ·������ȡһ����������:Class����
		
		Class<?> clazz = Class.forName(className);

		// 2.��ô��ݹ�������(�����String��)�����з�������Ŀ�ľ���Ϊ�˵��û�õķ���
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}

		// 3.�������������������ԡ���Ŀ�ģ��������Ի����ǻ�ȡ����ֵ�������ǻ�ȡ�����ϵ�ע�⣡
		System.out.println("-------------��������������������---------------");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}

		// 4.���������й�����������������
		System.out.println("--------------���������й�����--------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		//5.��ȡһ�����Class��������ַ�ʽ��
		//(1)֪�����ȫ·������Class<?> clazz = Class.forName("���ȫ·����");
		//(2)֪�������һ������   Class<?> clazz = ������.getClass();
		//(3)
		System.out.println("----------��ȡPerson�����Ϣ-------------");
		Person p = new Person();
		test(p);
		/*	test(p);��ӡ�������
		 * 	----------��ȡPerson�����Ϣ-------------
			public java.lang.String cn.tx.Person.toString()
			public java.lang.String cn.tx.Person.getAddress()
			public java.lang.String cn.tx.Person.getName()
			public java.lang.Integer cn.tx.Person.getId()
			public void cn.tx.Person.setName(java.lang.String)
			public void cn.tx.Person.setId(java.lang.Integer)
			public void cn.tx.Person.setAddress(java.lang.String)
			-------------��������������������---------------
			private java.lang.Integer cn.tx.Person.id
			private java.lang.String cn.tx.Person.name
			private java.lang.String cn.tx.Person.address
			--------------���������й�����--------------
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
		//Class<? extends Object>��ʾͨ�������ȡ�Ķ�������Ͳ�ȷ��������һ����Object�������
		//�ȼ���Class<?> clazz = obj.getClass();
		Class<? extends Object> clazz = obj.getClass();
		// 2.��ô��ݹ�������(�����String��)�����з�������Ŀ�ľ���Ϊ�˵��û�õķ���
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}

		// 3.�������������������ԡ���Ŀ�ģ��������Ի����ǻ�ȡ����ֵ
		System.out.println("-------------��������������������---------------");
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}

		// 4.���������й�����������������
		System.out.println("--------------���������й�����--------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}

}
