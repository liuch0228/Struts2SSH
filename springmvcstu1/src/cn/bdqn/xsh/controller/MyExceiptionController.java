package cn.bdqn.xsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.xsh.exceptions.BusinessException;

@Controller
@RequestMapping("/myexcp")
public class MyExceiptionController {
	
	@RequestMapping("myec.do")
	public String showDetail(){
		try {
			int n = 1/0;
		} catch (Exception e) {
//			throw new RuntimeException("С���������˰ɣ�������ѽ");
			throw new BusinessException("�Զ����쳣������");
		}
		return null;
	}
}
