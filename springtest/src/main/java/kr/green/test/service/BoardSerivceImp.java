package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDao;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.UserVo;

@Service
public class BoardSerivceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> boardList() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo getboard(Integer num) {
		// 검색할 번호가 없기 때문에 게시글을 가져올 수 없으므로 게시글이 없다는 의미로 null을 반환(리턴)
		if(num == null) {
			return null;
		}
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(UserVo user, BoardVo board) {
		BoardVo oriBoard = boardDao.getBoard(board.getNum());
		if(oriBoard == null || !oriBoard.getWriter().equals(board.getWriter()) || !oriBoard.getWriter().equals(user.getId())) {
			System.out.println("메소드종료");
			return ;
		}
		oriBoard.setTitle(board.getTitle());
		oriBoard.setContent(board.getContent());
		System.out.println("수정된 게시글 : " + oriBoard);
		boardDao.updateBoard(oriBoard);			
	}


}
