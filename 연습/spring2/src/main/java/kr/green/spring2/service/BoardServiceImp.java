package kr.green.spring2.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring2.dao.BoardDao;
import kr.green.spring2.vo.BoardVo;
import kr.green.spring2.vo.UserVo;

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
	public void modifyBoard(BoardVo board, UserVo user) {
		BoardVo oriBoard = boardDao.getBoard(board.getNum()); 
		if(!oriBoard.getWriter().equals(board.getWriter())) {
			return ;
		}
		if(!oriBoard.getWriter().equals(user.getId())) {
			return ;
			
		}
		board.setIsDel("N");
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(Integer num, UserVo user) {
		BoardVo board = boardDao.getBoard(num);
		if(board == null) {
			return ;
		}
		if(!board.getWriter().equals(user.getId())) {
			return ;
		}
		board.setIsDel("Y");
		System.out.println(board);
		boardDao.deleteBoard(board);
	}

	@Override
	public void addViews(Integer num) {
		if(num == null) {
			return;
		}
		boardDao.updateViews(num);
	}
}
