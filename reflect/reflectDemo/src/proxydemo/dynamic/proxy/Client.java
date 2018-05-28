package proxydemo.dynamic.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		// ����������Ľӿ�ʵ�������
		 HireHouseImpl hhi = new HireHouseImpl();
		 //�����������:��һ�������Ǳ�����Ķ��������������ڶ����Ǳ���������������нӿڣ��������������Զ��������Ľ�ɫ
		 HireHouse hh =
		 (HireHouse)Proxy.newProxyInstance(hhi.getClass().getClassLoader(),
		 hhi.getClass().getInterfaces(), new HireProxy(hhi)); //���ر��������Ľӿڵ�ʵ��
		 hh.hire();

		// ��list������
//		List list = new ArrayList();
//		List hh1 = (List) Proxy.newProxyInstance(list.getClass()
//				.getClassLoader(), list.getClass().getInterfaces(),
//				new HireProxy(list));
//		hh1.add("����");
//		hh1.get(0);//�������������з�������������

	}
}
