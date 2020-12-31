package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.UserVo;

public interface UserDao {
	public String getEmail(String id);

	public String getName(String id);

	public UserVo getUser(String id);

	public Integer getAge(String id);

	public ArrayList<UserVo> getAllUser();

	public void insertUser(@Param("user")UserVo user);

}
