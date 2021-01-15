package kr.green.spring2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring2.dao.BoardDao;
import kr.green.spring2.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> boardlist() {
		ArrayList<BoardVo> board = boardDao.getBoardList();
		return board;
	}

	@Override
	public BoardVo getBoard(Integer num) {
		if(num == null)
			return null;
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

	@Override
	public void insertBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}
}
