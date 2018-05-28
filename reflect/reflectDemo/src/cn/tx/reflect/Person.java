package cn.tx.reflect;

/**
 * 注解初步了解
 * @author Administrator
 *
 */
public class Person {
	private Integer id;
	private String name;
	private String address;
	
	
	public Person() {
		super();
	}
	
	public Person(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static void printInfo(){
		System.out.println("静态方法反射调用");
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", id=" + id + ", name=" + name
				+ "]";
	}
	

}
