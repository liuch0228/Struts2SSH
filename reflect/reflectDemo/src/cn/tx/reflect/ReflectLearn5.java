package cn.tx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���临�ƶ���
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
		//��ô��ݹ����Ķ�������Ժ͹�����
		Class<? extends Object> class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Constructor constructor = class1.getConstructor();
		Object instance = constructor.newInstance(null);
		for (Field f : fields) {
			//�����������
			String name = f.getName();
			//�����������
			Class<?> type = f.getType();
			//������Զ�Ӧ��set����
			String setMethodName = "set"+ name.substring(0,1).toUpperCase()+name.substring(1);
			String getMethodName = "get"+ name.substring(0,1).toUpperCase()+name.substring(1);
			//���get����
			Method gmethod = class1.getDeclaredMethod(getMethodName, null);
			//����get������ñ����ƶ����һ������ֵ
			Object gresult = gmethod.invoke(obj, null);
			//get�����Ĳ���������string,����ֵ����Ҳ��
			Method smethod = class1.getDeclaredMethod(setMethodName,type);
//			Method smethod = class1.getDeclaredMethod(setMethodName,gmethod.getReturnType());
			smethod.invoke(instance, gresult);
			
		}
		return instance;
	}
}
