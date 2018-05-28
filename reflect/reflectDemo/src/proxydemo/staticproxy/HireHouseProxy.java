package proxydemo.staticproxy;
/**
 * 静态代理
 * 代理类，需要实现接口
 * @author Administrator
 *
 */
public class HireHouseProxy implements HireHouse {

	private HireHouse hh;//代理对象，持有真实对象的引用
	
	
	public HireHouseProxy(HireHouse hh) {
		/*多态方式，接收接口的实现类对象，为静态代理，缺点是，只能给租房这件事做代理，
		 *因为传递进来的是HireHouse这个接口的实现类对象 ，不能代理其他的事情*/
		super();
		this.hh = hh;
	}


	@Override
	public void hire() {
		System.out.println("收中介费");//代理做的事情
		hh.hire();//真实对象租房
		System.out.println("扣押金");//代理做的

	}

}
