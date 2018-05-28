package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * ������ȡһ�����Class��������ַ�ʽ��
		(1)֪�����ȫ·������Class<?> clazz = Class.forName("���ȫ·����");
		(2)֪��������֣�  Class<?> clazz = ����.class;
		(3)֪�������һ������ ��  Class<?> clazz = ������.getClass();
 * @author Administrator
 *
 */
public class ReflectLearn2 {
	
	private static String className = "java.lang.String";
	public static void main(String[] args) throws Exception {
		
		//����������ֻ�ȡ���Class����
		getClazzByClassName();
		//���ݶ����ȡClass���󣬷����ȡ��ķ��������ԣ�������
		getCalzzByObject(new Person());
	}
	
	public static void getClazzByClassName(){
		Class<?> clazz = Person.class;//����.class��ȡ���Class����
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
	}
	
	/**
	 * ������Ķ����ȡClass����
	 * @param obj
	 */
	public static void getCalzzByObject(Object obj){
		//Class<? extends Object>��ʾͨ�������ȡ�Ķ�������Ͳ�ȷ��������һ����Object�������
		//�ȼ���Class<?> clazz = obj.getClass();
		Class<? extends Object> clazz = obj.getClass();
		// 2.��ô��ݹ�������(�����String��)�����з�������Ŀ�ľ���Ϊ�˵��û�õķ���
		System.out.println("----------------��ȡ������������ķ���-------------------");
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
		System.out.println("--------------���������й�����-----------------");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}

}
/*	getCalzzByObject(new Person());��ӡ�������
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
