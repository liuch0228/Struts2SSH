package cn.bdqn.xsh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"/three","/three1"})
public class index3Controller {

	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest req,
			String userName, Integer age){
		String name = req.getParameter("userName");
		System.out.println("request 获取到的name: "+name);
		System.out.println("Welcome, Spring mvc, Hello:"+userName);
		System.out.println("age: "+age);
		return "index";
	}
	
	@RequestMapping("/main.html")
	public String main(){
		System.out.println("welcome, main.html");
		return "main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(value="name",required=true)String name){
		System.out.println("name: "+name);
		if (name.equals("admin")) {
			return "redirect:main.html";
		}else{
			return "login";
		}
		
	}
}




