package kr.green.spring2.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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

	@Override
	public void modifyBoard(BoardVo board, HttpServletRequest request) {
		BoardVo oriBoard = boardDao.getBoard(board.getNum()); 
		if(!oriBoard.getWriter().equals(board.getWriter()) || !oriBoard.getWriter().equals(request.getSession())) {
			return ;
		}
		board.setIsDel("N");
		boardDao.updateBoard(board);
	}
}
