package cn.tx.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import cn.tx.annotation.AnnoTest;

public class Caculate {
//	@AnnoTest(value = "sss") 
	//AnnoTestע���ж�����@Target(value = { ElementType.METHOD,ElementType.TYPE }) 
	//���������a�����@AnnoTestע�⣬�ᱨ��The annotation @AnnoTest is disallowed for this location
	private int a;

	@AnnoTest(value = "��ӵĽ���ǣ�")
	public int add(int a,int b){
		return a+b;
}

}
