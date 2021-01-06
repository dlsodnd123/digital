package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(BoardVo board, UserVo user);

	void deleteBoard(Integer num, UserVo user);

}
