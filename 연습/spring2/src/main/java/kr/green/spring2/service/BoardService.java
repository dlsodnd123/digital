package kr.green.spring2.service;

import java.util.ArrayList;

import kr.green.spring2.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> boardlist();

	BoardVo getBoard(Integer num);

	void insertBoard(BoardVo board);


}
