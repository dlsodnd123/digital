package kr.green.test.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.Utils.UploadFileUtils;
import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.UserService;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.LikeVo;
import kr.green.test.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UserService userService;
	
	private String uploadPath = "D:\\JAVA_LRW\\upfile";
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	// 현재 페이지정보를 화면에서 전달받아옴(매개변수) : Criteria cri 추가
	public ModelAndView boardListGet(ModelAndView mv, HttpServletRequest request, Criteria cri) { 
		// (수정) 전체 게시글을 가져오는 서비스의 getBoradList()를 현재 페이지글을 가져오는 getBoardList(cri)로 수정
		ArrayList<BoardVo> list = boardService.boardList(cri);
		// 서비스에게 전체 게시글 갯수를 알려 달라 고 요청하여 변수에 저장
		int totalCount = boardService.getTotalCount(cri);
		// 한 페이지네이션에서 보여줄 최대 페이지 수를 임의로 선정하여 변수에 저장
		int displayPageNum = 3;
		
		PageMaker pm = new PageMaker(cri, displayPageNum, totalCount);
		
		mv.addObject("pm", pm);
		mv.addObject("boardList", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer num, Criteria cri) {
		boardService.views(num);
		BoardVo board = boardService.getboard(num);
		ArrayList<FileVo> fileList = boardService.getFileList(num);
		mv.addObject("fList", fileList);
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
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, MultipartFile[] fileList) throws Exception {
		boardService.registerBoard(board);
		//첨부파일 배열에 첨부파일이 있으면
		if(fileList != null && fileList.length != 0) {
		// 화면에서 넘어온 파일이 있고, 파일명이 0글자가 아닐때		
			for(MultipartFile file : fileList) {
				if(file != null && file.getOriginalFilename().length() != 0) {
					//파일을 업로드하고, 업로된 경로를 fileName에 저장
					String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
					//DB에 첨부파일 정보를 추가
					boardService.registerFile(fileName, board.getNum(), file.getOriginalFilename());		
				}
			}
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		
		BoardVo board = boardService.getboard(num);
		ArrayList<FileVo> flieList = boardService.getFileList(num);
		mv.addObject("flieList", flieList);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVo board, HttpServletRequest request, MultipartFile[] fileList) throws IOException, Exception {
		UserVo user = userService.getUser(request);
		// 내용 수정
		boardService.modifyBoard(user, board);
		// 기존 파일 삭제
		boardService.deleteFile(board.getNum());
		// 새 첨부파일 업로드 및 DB에 추가
		if(fileList != null && fileList.length != 0) {
				for(MultipartFile file : fileList) {
					if(file != null && file.getOriginalFilename().length() != 0) {
						String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
						boardService.registerFile(fileName, board.getNum(), file.getOriginalFilename());		
					}
				}
			}
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
	@ResponseBody
	@RequestMapping(value = "/board/download")
	public ResponseEntity<byte[]> downloadFile(String filename)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+filename);

	        filename = filename.substring(filename.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(filename.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	@RequestMapping(value = "/board/like", method = RequestMethod.POST)
	@ResponseBody
	public String boardLikePost(LikeVo likeVo) {
		boardService.updateLike(likeVo);
		return "success";
	}
}
