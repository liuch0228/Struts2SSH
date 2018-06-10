package cn.bdqn.xsh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class IndexController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		System.out.println("Hello, Spring mvc!");
		String name = req.getParameter("name");
		System.out.println(name);
		return new ModelAndView("/index.jsp");
	}

}
