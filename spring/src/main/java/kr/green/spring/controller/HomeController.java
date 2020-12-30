package kr.green.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.vo.UserVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		mv.setViewName("main/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUpPost(ModelAndView mv, UserVo user) {
		System.out.println(user);
		mv.setViewName("redirect/");
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
}
