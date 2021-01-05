package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, String id, String pw) {
		// 수정 전 : id와 pw가 일치하는 회원이 있으면 true, 없으면 false를 가져옴
		// 수정 후 : id와 pw가 일치하는 회원이 있으면 회원 정보를 가져오고, 없으면 null을 가져옴
		// boolean isUser = userService.isUser(id, pw);
		UserVo isUser = userService.isUser(id, pw);
		
		mv.addObject("user", isUser);
		if(isUser != null) {
			mv.setViewName("redirect:/");			
		} else {
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
			// localhost:8080/test/signup
			// mv.setViewName("/main/home");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest r) {
		// 세션에 저장된 user 정보를 삭제
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
}
