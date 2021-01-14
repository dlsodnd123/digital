package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.UserService;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	// 현재 페이지정보를 화면에서 전달받아옴(매개변수) : Criteria cri 추가
	public ModelAndView boardListGet(ModelAndView mv, HttpServletRequest request, Criteria cri) { 
		System.out.println("현재 페이지 정보 : " + cri);
		// (수정) 전체 게시글을 가져오는 서비스의 getBoradList()를 현재 페이지글을 가져오는 getBoardList(cri)로 수정
		ArrayList<BoardVo> list = boardService.boardList(cri);
		// 서비스에게 전체 게시글 갯수를 알려 달라 고 요청하여 변수에 저장
		int totalCount = boardService.getTotalCount(cri);
		System.out.println("게시글의 총 개수 : " + totalCount);
		// 한 페이지네이션에서 보여줄 최대 페이지 수를 임의로 선정하여 변수에 저장
		int displayPageNum = 3;
		
		PageMaker pm = new PageMaker(cri, displayPageNum, totalCount);
		System.out.println("페이지메이커 정보 : " + pm);
		
		mv.addObject("pm", pm);
		mv.addObject("boardList", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num, Criteria cri) {
		boardService.views(num);
		BoardVo board = boardService.getboard(num);
		mv.addObject("cri", cri);
		mv.addObject("board", board);		
		mv.setViewName("/board/detail");
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board) {
		boardService.registerBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		
		BoardVo board = boardService.getboard(num);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVo board, HttpServletRequest request) {
		UserVo user = userService.getUser(request);
		boardService.modifyBoard(user, board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		UserVo user = userService.getUser(request);
		boardService.deleteBoard(num, user);
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
