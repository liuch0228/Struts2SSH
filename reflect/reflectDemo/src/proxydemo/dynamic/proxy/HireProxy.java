package proxydemo.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��̬�������ʵ��InvocationHandler�ӿڣ�ͨ������ȥ���ñ�����Ľӿ�
 * @author Administrator
 * 
 */
public class HireProxy implements InvocationHandler {
	// ���������ʵ��ɫ
	private Object obj;// ��ʵ��ɫ��Ҫ���κζ���������ֻ���ǳ���Object���͵Ķ���
	
	public HireProxy(Object obj) {
		super();
		this.obj = obj;
	}

/**
 * jdk��̬����������������ʵ�ֽӿ�
 * ������Ķ����Ȼʵ�ֹ�ͬ��Hire�ӿڣ���ô���з���
 * method:������Ķ���Ľӿ��еķ�����Ҫ���÷����������ж��󣬴˴����������Ǳ����������˱���Ҫָ��������Ķ���
 * args�Ǳ��������ӿڵķ����Ĳ�����ͨ���������invoke�����Ĳ���proxy�����method����
 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("ǰ�ù���");
//		for (Object object : args) {
//			System.out.print("invoke�����еĵ�����������"+object +" ");//��list������ʱ������
//		}
		Object invoke = method.invoke(obj, args);
		System.out.println("\n���ù���");
		return invoke;
	}

}
