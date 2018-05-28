package proxydemo.staticproxy;

public class Client {

	public static void main(String[] args) {
		HireHouse proxyHire = new HireHouseProxy(new HireHouseImpl());
		System.out.print("---通过代理租房：");
		proxyHire.hire();//通过代理租房
		System.out.print("---真实对象自己租房：");
		new HireHouseImpl().hire();//真实对象自己租房
		
	}
}
