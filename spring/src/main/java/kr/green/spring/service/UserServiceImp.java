package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.UserDao;
import kr.green.spring.vo.UserVo;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public String getEmail(String id) {
		return userDao.getEmail(id);
	}

	@Override
	public String getName(String id) {
		return userDao.getName(id);
	}

	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public Integer getAge(String id) {
		return userDao.getAge(id);
	}

	@Override
	public ArrayList<UserVo> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public boolean isUser(String id, String pw) {
		//Dao에게 id를 전달하여 회원 정보를 요청
		UserVo user = userDao.getUser(id);
		//DB가져온 회원 정보의 비밀번호와 입력받은 비밀번호를 비교하여 같으면 true, 다르면 false를 반환
		// 입력한 id와 일치하는 회원 정보가 없는 경우
		if(user == null)
			return false;
		if(user.getPw().equals(pw)){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean signup(UserVo user) {
		// 아이디가 중복되면 회원가입 실패를 알림
		//  => 아이디와 일치하는 정보를 DB에서 가져옴
		UserVo tmpUser = userDao.getUser(user.getId());
		//  => 자겨온 회원 정보가 있으면 가입된 아이디 => 아이디 중복
		if(tmpUser != null) {
			return false;
		}
		// 아이디가 중복되지 않았으면 회원가입을 하고, 성공을 알림
		// 회원정보의 유효성 검사를 하여 유효성 검사에 맞지 않으면 실패를 알림
		// 아이디 유효성 검사 : 아이디가 입력안되면 회원가입 불가능
		if(user.getId() == null || user.getId().length() == 0) {
			return false;			
		}
		// 비밀번호 유효성 검사 : 비밀번호가 입력 안되면 회원강비 불가능
		if(user.getPw() == null || user.getPw().length() == 0) {
			return false;			
		}
		// 회원가입 => user테이블에 회원정보를 추가(insert)
		userDao.insertUser(user);
		return true;
	}


}
