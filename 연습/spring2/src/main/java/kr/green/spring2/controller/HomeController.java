package kr.green.spring2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring2.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, String id, String pw) {
		
		boolean isUser = userService.isUser(id, pw);
		if(isUser) {
			// 로그인 성공(isUser = true)시 홈화면으로 이동
			mv.setViewName("redirect:/");
		}else {
			// 로그인 실패(isUser = false)시 로그인화면으로 이동
			mv.setViewName("redirect:/login");
		}
		mv.setViewName("/main/login");
		return mv;
	}
	
}
