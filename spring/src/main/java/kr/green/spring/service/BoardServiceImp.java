package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.Pagination.Criteria;
import kr.green.spring.dao.BoardDao;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		// ArrayList<BoardVo> list = boardDao.getBoardList();
		// return list;
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoard(Integer num) {
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(BoardVo board, UserVo user) {
		// 5-10. 게시글 번호로 원본 게시글 정보를 가져옴.
		BoardVo oriBoard = boardDao.getBoard(board.getNum());
		// 5-11. 원본 게시글 정보에 수정된 제목과으로 바꿈.
		oriBoard.setTitle(board.getTitle());
		oriBoard.setContent(board.getContent());
		// 비회원이거나 작성자와 로그인한 유저가 같지 않으면 수정하지 않음
		if(user == null || !user.getId().equals(oriBoard.getWriter())) {
			return;
		}
		// 5-12. 수정된 게시글을 DB에 업데이트
		boardDao.updateBoard(oriBoard);
	}

	@Override
	public void deleteBoard(Integer num, UserVo user) {
		BoardVo board = boardDao.getBoard(num);
		board.setIsDel("Y");
		if(user == null || !user.getId().equals(board.getWriter())) {
			return;
		}
		boardDao.updateBoard(board);
	}

	@Override
	public void view(Integer num) {
		if(num == null) {
			return ;
		}
		boardDao.updateViews(num);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}
	
}
