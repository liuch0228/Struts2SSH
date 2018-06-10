package cn.bdqn.xsh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.xsh.pojo.User;

@Controller
@RequestMapping("/four")
public class index4Controller {

	//http://localhost:8080/springmvcstu1/four/register?name=zs&age=21
	@RequestMapping("/register")
	public String register(User user, Model model){
		System.out.println(user.toString());
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping("/register2")
	@ResponseBody
	public User register2(User user){
		System.out.println("User message: "+ user.toString());
		return user;
	}
	
	@RequestMapping("/register3")
	@ResponseBody
	public List<User> register3(User user){
		System.out.println("User message: "+ user.toString());
		User u2 = new User();
		u2.setAge(21);
		u2.setBirthday(new Date());
		u2.setName("lisi");
		
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(u2);
		
		return list;
	}
}





