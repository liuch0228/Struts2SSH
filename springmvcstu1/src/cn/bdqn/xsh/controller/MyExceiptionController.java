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
//			throw new RuntimeException("小样儿，错了吧？来打我呀");
			throw new BusinessException("自定义异常发生了");
		}
		return null;
	}
}
