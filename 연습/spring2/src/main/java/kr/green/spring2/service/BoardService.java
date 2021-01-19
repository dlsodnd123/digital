package kr.green.spring2.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring2.vo.BoardVo;
import kr.green.spring2.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> boardlist();

	BoardVo getBoard(Integer num);

	void insertBoard(BoardVo board);

	void modifyBoard(BoardVo board, UserVo user);


}
