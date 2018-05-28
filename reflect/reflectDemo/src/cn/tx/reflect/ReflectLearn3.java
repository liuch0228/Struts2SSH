package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * �� ��Class����Ҫ���յķ�����
 * �����ȡ�������ԡ�������������
 * @author Administrator
 *
 */
public class ReflectLearn3 {
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = Class.forName("cn.tx.Person");
		//1.�����ȡ�������ֵ
		Field field = clazz.getDeclaredField("address");
		System.out.println("�����ȡ�������������ϢΪ��" + field);
		//��ӡ����� �����ȡ�������������ϢΪ��private java.lang.String cn.tx.Person.address
		//�������ԣ����Ȼ�ȡ����
		
		//2.�����ȡ����������ָ��Ҫ��ȡ�ķ������͸÷����ķ���ֵ���ͣ�ֻ���������ǲ��еģ�����Ҫ֪�����������б��еĲ�������
		/*Method java.lang.Class.getDeclaredMethod(String name, Class<?>... parameterTypes) 
		 *Class<?>... �ǿɱ��������ʾһ��Ԫ�ظ�����ȷ����Class���� */
		//Person���getName()������û���βΣ�Class����дnew Class[]{}
		Method method = clazz.getDeclaredMethod("getName", new Class[]{});
		System.out.println("��ȡ����getName()������"+method);//��ȡ����getName()������public java.lang.String cn.tx.Person.getName()
		Method method2 = clazz.getDeclaredMethod("setName", new Class[]{String.class}); //setName������һ��String���͵��β�
		System.out.println("��ȡ����setName()������"+method2);//��ȡ����getName()������public java.lang.String cn.tx.Person.getName()
		
		//3.�����ȡ�޲ι�����Constructor<?> java.lang.Class.getDeclaredConstructor(Class<?>... parameterTypes) 
		Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{}); //����Ϊ������������
		System.out.println(constructor); //��ӡpublic cn.tx.Person()
		Constructor<?> constructor2 = clazz.getDeclaredConstructor(new Class[]{Integer.class,String.class,String.class});
		System.out.println(constructor2); //public cn.tx.Person(java.lang.Integer,java.lang.String,java.lang.String)
		
		//4.ʹ�ù�������������: Constructor���public T newInstance(Object ... initargs)
		Object object = constructor.newInstance(new Object[]{});
		System.out.println(object); //Person [address=null, id=null, name=null]
//		Object object2 = constructor.newInstance(new Object[]{1,"����","����"});
		Object object2 = constructor2.newInstance(1,"����","����"); 
		System.out.println(object2);//Person [address=����, id=1, name=����]
		
		//5.��������
		//���������з���
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			//��÷���������;
			String name = m.getName(); // ����һ�д�ϵ㣬F6�������ԣ��鿴��������ù���
			if(name.startsWith("set")){
				//���set�ַ��������ֵ
				String fieldName = name.substring(3);
				//���������
				fieldName = fieldName.substring(0,1).toLowerCase()+ fieldName.substring(1);
				//��÷�����Ӧ������
				Field field2 = clazz.getDeclaredField(fieldName);//ע�⣬����getField()
				//������Զ�Ӧ�ľ�������
				Class<?> type = field2.getType();
				if(type == Integer.class){
					//ͨ��method���������Person��ķ�������һ�������ǵ��÷����Ķ��󣬵ڶ��������Ƿ�����ʵ��ֵ
					m.invoke(object2, 2); //�൱��person.setId(2)
				}
				if(type == String.class && "address".equals(fieldName)){
					m.invoke(object2, "�Ͼ�");
				}
				if(type == String.class && "name".equals(fieldName)){
					m.invoke(object2, "tom");
				}
			}
		}
		
		//6.ֱ���������ԣ�field.setAccessible(true)
		Field field2 = clazz.getDeclaredField("name");
		field2.setAccessible(true);//��˽�е����Կ��Ա�����
		field2.set(object2, "marry");
		System.out.println(object2);
		
		
		
		
	
	}
}
