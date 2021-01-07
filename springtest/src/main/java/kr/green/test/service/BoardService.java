package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> boardList();

	BoardVo board(Integer num);

}
