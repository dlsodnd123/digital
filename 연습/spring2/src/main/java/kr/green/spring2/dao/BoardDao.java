package kr.green.spring2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring2.pagination.Criteria;
import kr.green.spring2.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList(@Param("cri")Criteria cri);

	BoardVo getBoard(@Param("num")Integer num);

	void insertBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo board);

	void deleteBoard(@Param("board")BoardVo board);

	void updateViews(@Param("num")Integer num);

	int selectTotalCount();


}
