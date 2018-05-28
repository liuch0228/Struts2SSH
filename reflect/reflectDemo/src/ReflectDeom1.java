import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDeom1 {

	public static void main(String[] args) throws Exception {
		// List<?> list = new ArrayList();  //<?>�е��ʺ�Ϊ���ͣ���ʾ��֪������list�����д�ŵ�ʵ��������ʲô���ã���ʾ
		Class<?> class1 = Class.forName("cn.tx.Person");
		// ��ȡ����Ϊaddress ���������
		Field field = class1.getDeclaredField("address");
		System.out.println("��ȡ��������ֵ��ȫ·�����ǣ�" + field);
		// ��̬��ȡ���Բ�����ֵ���Ȼ�ȡ����Ȼ������������ֵ
		// ��ȡ����������û�в�����
		Method method = class1.getDeclaredMethod("getName", new Class[] {});
		System.out.println(method);
		Method method2 = class1.getDeclaredMethod("setName",
				new Class[] { String.class });
		System.out.println(method2);
		// ����޲ι�����
		Constructor<?> constructor = class1
				.getDeclaredConstructor(new Class[] {});
		// System.out.println(constructor);

		Constructor<?> constructor2 = class1
				.getDeclaredConstructor(new Class[] { Integer.class,
						String.class, String.class });
		// System.out.println(constructor2);

		// �������Ĭ�Ϲ�������ȡ����
		Object instance = constructor.newInstance(new Object[] {});
		System.out.println(instance.toString());// ˵����ȡ���ľ���person
		// �����вι����ȡ����
		Object instance2 = constructor2.newInstance(new Object[] { 1, "����",
				"����" });
		System.out.println(instance2);

	}

}
