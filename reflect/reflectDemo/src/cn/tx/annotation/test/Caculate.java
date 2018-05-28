package cn.tx.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import cn.tx.annotation.AnnoTest;

public class Caculate {
//	@AnnoTest(value = "sss") 
	//AnnoTest注解中定义了@Target(value = { ElementType.METHOD,ElementType.TYPE }) 
	//如果在属性a上面加@AnnoTest注解，会报：The annotation @AnnoTest is disallowed for this location
	private int a;

	@AnnoTest(value = "相加的结果是：")
	public int add(int a,int b){
		return a+b;
}

}
