package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.vo.BoardVo;
import kr.green.test.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> boardList();

	BoardVo getboard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(UserVo user, BoardVo board);

	void deleteBoard(Integer num, UserVo user);

}
