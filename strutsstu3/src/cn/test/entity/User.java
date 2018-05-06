package cn.test.entity;

public class User {

	private String name;
	private String age;
	private String password;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", password=" + password
				+ "]";
	}

}
