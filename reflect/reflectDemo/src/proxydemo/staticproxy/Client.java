package proxydemo.staticproxy;

public class Client {

	public static void main(String[] args) {
		HireHouse proxyHire = new HireHouseProxy(new HireHouseImpl());
		System.out.print("---ͨ�������ⷿ��");
		proxyHire.hire();//ͨ�������ⷿ
		System.out.print("---��ʵ�����Լ��ⷿ��");
		new HireHouseImpl().hire();//��ʵ�����Լ��ⷿ
		
	}
}
