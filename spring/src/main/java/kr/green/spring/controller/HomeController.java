package kr.green.spring.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.UserService;
import kr.green.spring.vo.UserVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv, String name) {
		System.out.println("이름(get) : " + name);
		//http://localhost:8080/spring/?name=임꺽정
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView homePost(ModelAndView mv, String name, String fruit) {
		System.out.println("이름(post) : " + name);
		System.out.println("과일(post) : " + fruit);
		//http://localhost:8080/spring/?name=임꺽정
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		
		//model.addAttribute("변수명", 값)
		//값으로 문자열, 정수, 실수, 객체 등 다양한 값들을 보낼 수 있다.
		mv.addObject("name", "홍길동");
		mv.setViewName("/main/test");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUpGet(ModelAndView mv, UserVo user) {
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUpPost(ModelAndView mv, UserVo user) {
		System.out.println(user);
		// 회원가입을 진행시키키 위해 userService에게 일을 시키기위한 메소드를 생성해보세요.
		boolean isSignup = userService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/login");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/tiles", method = RequestMethod.GET)
	public ModelAndView tilesGet(ModelAndView mv) {
		mv.setViewName("/main/tiles");
		return mv;
	}
	@RequestMapping(value = "/tiles2", method = RequestMethod.GET)
	public ModelAndView tilesGet2(ModelAndView mv) {
		mv.setViewName("/main/tiles2");
		return mv;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listGet(ModelAndView mv) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("임꺽정");
		list.add("이순신");
		mv.addObject("list", list);
		mv.addObject("option", "번호");
		mv.setViewName("/main/list");
		String email = userService.getEmail("abcd12345");
		String name = userService.getName("abcd1234");
		UserVo user = userService.getUser("abcd1234");
		Integer age = userService.getAge("abcd1234");
		System.out.println(email);
		System.out.println(name);
		System.out.println(user);
		System.out.println(age);
		return mv;
	}
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ModelAndView userListGet(ModelAndView mv) {
		ArrayList<UserVo> list = new ArrayList<UserVo>();
		// 모든 회원 정보를 가져오는 코드
		list = userService.getAllUser();
		mv.addObject("list",list);
		mv.setViewName("/main/list2");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, String id, String pw) {
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		boolean isUser = userService.isUser(id, pw);
		if(isUser) {
			mv.setViewName("redirect:/"); // 로그인성공시
		} else {
			mv.setViewName("redirect:/login"); // 로그인실패시
		}
		return mv;
	}
}
