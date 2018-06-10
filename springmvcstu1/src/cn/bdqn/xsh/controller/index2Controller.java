package cn.bdqn.xsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class index2Controller {
	
	@RequestMapping("/index2")
	public String index2(){
		System.out.println("Hello, Spring mvc index2");
		return "/index.jsp";
	}
	
	@RequestMapping(value={"/index","/hehe"})
	public ModelAndView index(){
		System.out.println("Hello, Spring mvc  main>index");
		return new ModelAndView("/index.jsp");
	}
}
