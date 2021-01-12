package kr.green.spring2.service;

import kr.green.spring2.vo.UserVo;

public interface UserService {

	UserVo isUser(String id, String pw);

	boolean Singup(UserVo user);
}
