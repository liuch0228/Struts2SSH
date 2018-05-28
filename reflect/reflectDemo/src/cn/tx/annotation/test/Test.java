package cn.tx.annotation.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import cn.tx.annotation.AnnoTest;
import cn.tx.annotation.enums.HttpMethod;

/**
 * ���õı�ʾ��ע�⣺@Test @Override @SuppressWarnings
 * 
 * @author Administrator
 * 
 */
public class Test {

	@org.junit.Test
	public void test() {

	}

	// @AnnoTest(value = "tst")
	@Deprecated
	// ��ʱ��������ʹ�õ�ע��
	public void method() {

	}

	/**
	 * @SuppressWarningsѹ�ƾ����ע�� unchecked ��������ʱ�ľ��� rawtypes
	 *                          ԭʼ���ͣ�Ҳ���ǲ�ʹ�÷��ͣ��ڶ����ʱ��ѹ�Ʒ��͵ľ���
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public void method1() {
		@SuppressWarnings("unused")
		List list = new ArrayList();// ��д��������ʱ������ֻ�ɫ�����߾��棡
		list.add("lisi");
	}

	@org.junit.Test
//	@AnnoTest(value = "test", location = { String.class }, method = HttpMethod.GET)
	// �Ǳ�ʶ��ע����������ڷ������������ʱ
	public void method3() {

	}

	@org.junit.Test
	public void testEnum() {
		System.out.println(HttpMethod.GET);
	}
	
	@org.junit.Test
	public void testAdd(){
		new Caculate().add(3, 5); //�������ã�add���������ע�ⲻ��������
	}

	@org.junit.Test
	public void testAdd1(){
		Class<?> clazz = Caculate.class;
		try {
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("add", int.class,int.class);
			//�ж�һ�����������Ƿ����ĳ��ע��
			boolean isPres = method.isAnnotationPresent(AnnoTest.class);
			if(isPres){
				//����һ�����ȡע��
				AnnoTest annotation = method.getAnnotation(AnnoTest.class);
				//���ע���ϵ�ֵ
				String value = annotation.value();
				//����ķ�ʽ����add()����
				Object result = method.invoke(obj, 2,3);
				System.out.println(value+result); //����̨��� ��  ��ӵĽ���ǣ�5
				//���ע���ϵ�@Retention(value = RetentionPolicy.SOURCE),����ʱʱ�����н����
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
