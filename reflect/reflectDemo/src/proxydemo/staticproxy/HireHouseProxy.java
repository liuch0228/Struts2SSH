package proxydemo.staticproxy;
/**
 * ��̬����
 * �����࣬��Ҫʵ�ֽӿ�
 * @author Administrator
 *
 */
public class HireHouseProxy implements HireHouse {

	private HireHouse hh;//������󣬳�����ʵ���������
	
	
	public HireHouseProxy(HireHouse hh) {
		/*��̬��ʽ�����սӿڵ�ʵ�������Ϊ��̬����ȱ���ǣ�ֻ�ܸ��ⷿ�����������
		 *��Ϊ���ݽ�������HireHouse����ӿڵ�ʵ������� �����ܴ�������������*/
		super();
		this.hh = hh;
	}


	@Override
	public void hire() {
		System.out.println("���н��");//������������
		hh.hire();//��ʵ�����ⷿ
		System.out.println("��Ѻ��");//��������

	}

}
