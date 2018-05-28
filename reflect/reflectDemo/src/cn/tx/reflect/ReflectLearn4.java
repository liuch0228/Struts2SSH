package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ������÷���
 * Object java.lang.reflect.Method.invoke(Object obj, Object... args)
 * ����ײ㷽����ʵ����������һ���������Ǹ�ʵ�����󣬵ڶ��������Ƿ����Ĳ����б�invoke�ķ���ֵ����ʵ�������ķ���ֵ
 * ����ײ㷽���Ǿ�̬�ģ���ô���Ժ���ָ����obj����������Ϊnull
 * ����ײ㷽��������β�Ϊ0�������ṩ��args���鳤�ȿ���Ϊ0��null(�μ������method2.invoke(object))
 * @author Administrator
 * 
 */
public class ReflectLearn4 {
	public static void main(String[] args) throws Exception {

		Class<?> clazz = Class.forName("cn.tx.Person");
		//��ȡcn.tx.Person����޲ι���
		Constructor<?> constructor = clazz.getConstructor();
		//��ȡһ��ʵ��
		Object object = constructor.newInstance();
		
		//�������setName()������method.invoke�����صľ��ǵ��õķ����ķ���ֵ
		Method method = clazz.getDeclaredMethod("setName", String.class);
		Object invoke = method.invoke(object, "james");//set������û�з���ֵ���˴�invoke�� null
		System.out.println(object.toString()); //Person [address=null, id=null, name=james]
		
		//�������getName()����
		Method method2 = clazz.getDeclaredMethod("getName");
		Object invoke2 = method2.invoke(object);
		System.out.println(invoke2);
		
		//������þ�̬����
		Method method3 = clazz.getDeclaredMethod("printInfo",null); //printInfo����û�в�����дnull 
		method3.invoke(null,null);//��̬��������һ����������Ϊnull
	
	}

}
