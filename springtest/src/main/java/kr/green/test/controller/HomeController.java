package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.UserService;
import kr.green.test.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	//url이 localhost:8080/test/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		
		//abcd1234의 이메일을 가져옴
		String id = "abcd1234";
		String email = userService.getEmail(id);
		UserVo user = userService.getUser(id);
		System.out.println(email);
		System.out.println(user);
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv,String username, String password) {
		
		System.out.println("id : " + username);
		System.out.println("pw : " + password);
		boolean isUser = userService.isUser(username, password);
		System.out.println("결과 : " + isUser);
		if(isUser) {
			mv.setViewName("redirect:/");	
		}
		else {
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		
		mv.setViewName("/main/signup");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, UserVo user) {
		System.out.println(user);
		
		boolean signup = userService.signup(user);
		System.out.println(signup);
		if(signup) {
			//localhost:8080/test/
			mv.setViewName("redirect:/");
			//localhost:8080/test/signup
			//mv.setViewName("/main/home");
		}else {
			mv.setViewName("redirect:/signup");
		}
		
		return mv;
	}
}






