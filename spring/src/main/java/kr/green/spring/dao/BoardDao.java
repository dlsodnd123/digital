package kr.green.spring.dao;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

}
