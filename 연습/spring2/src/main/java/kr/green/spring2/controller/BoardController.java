package kr.green.spring2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring2.service.BoardService;
import kr.green.spring2.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
		ArrayList<BoardVo> list = boardService.boardlist();
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num) {
		BoardVo board = boardService.getBoard(num);
		mv.addObject("board",board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
}
