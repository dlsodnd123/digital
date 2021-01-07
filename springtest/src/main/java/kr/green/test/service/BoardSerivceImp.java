package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDao;
import kr.green.test.vo.BoardVo;

@Service
public class BoardSerivceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> boardList() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo board(Integer num) {
		if(num == null) {
			return null;
		}
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

}
