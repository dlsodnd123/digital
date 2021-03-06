package kr.green.spring2.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring2.pagination.Criteria;
import kr.green.spring2.vo.BoardVo;
import kr.green.spring2.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> boardlist(Criteria cri);

	BoardVo getBoard(Integer num);

	void insertBoard(BoardVo board);

	void modifyBoard(BoardVo board, UserVo user);

	void deleteBoard(Integer num, UserVo user);

	void addViews(Integer num);

	int getTotalCount();


}
