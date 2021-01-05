package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDao;
import kr.green.test.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList() {
		ArrayList<BoardVo> list = boardDao.getBoardList();
		return list;
	}
}
