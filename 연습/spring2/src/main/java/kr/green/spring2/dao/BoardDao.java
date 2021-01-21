package kr.green.spring2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring2.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(@Param("num")Integer num);

	void insertBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo board);

	void deleteBoard(@Param("board")BoardVo board);


}
