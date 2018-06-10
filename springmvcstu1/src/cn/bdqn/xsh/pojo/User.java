package cn.bdqn.xsh.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	
	
	
	private String name;
	private Integer age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", birthday=" + birthday + ", name=" + name
				+ "]";
	}
	
	
	
}
