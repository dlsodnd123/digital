package kr.green.spring2.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring2.vo.UserVo;

public interface UserDao {

	UserVo getUser(@Param("id")String id);

}
