package kr.green.spring2.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring2.vo.UserVo;

public interface UserService {

	UserVo isUser(String id, String pw);

	boolean Singup(UserVo user);

	UserVo getUser(HttpServletRequest request);
}
