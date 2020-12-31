package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.UserVo;

public interface UserService {

	String getEmail(String id);

	String getName(String id);

	UserVo getUser(String id);

	Integer getAge(String id);

	ArrayList<UserVo> getAllUser();

	boolean isUser(String id, String pw);

	boolean signup(UserVo user);

}
