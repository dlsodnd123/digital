package kr.green.spring2.service;

import kr.green.spring2.vo.UserVo;

public interface UserService {

	boolean login(String id, String pw);

	boolean Singup(UserVo user);
}
