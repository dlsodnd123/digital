package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> boardList(Criteria cri);

	BoardVo getboard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(UserVo user, BoardVo board);

	void deleteBoard(Integer num, UserVo user);

	void views(Integer num);

	int getTotalCount(Criteria cri);

	void registerFile(String fileName, int num, String originalFilename);

	ArrayList<FileVo> getFileList(int num);

	void deleteFile(int num);



}
