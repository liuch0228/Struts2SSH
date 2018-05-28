package cn.tx.annotation;

public class Person {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override //标识性注解
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	

}
