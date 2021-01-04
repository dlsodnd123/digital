package kr.green.test.service;

import kr.green.test.vo.UserVo;

public interface UserService {

	String getEmail(String id);

	UserVo getUser(String id);

	boolean isUser(String id, String pw);

	boolean signup(UserVo user);

}
