package kr.green.spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring2.dao.UserDao;
import kr.green.spring2.vo.UserVo;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean isUser(String id, String pw) {
		UserVo user = userDao.getUser(id);
		// 입력한 id가 DB에 일치하는 id가 없으면 false반환
		if(user == null) {			
			return false;
		}
		// 입력한 id가 DB에 있고, 입력한 pw가 DB에서 가져온 회원정보의 pw랑 같으면 true반환
		if(user.getPw().equals(pw)) {
			return true;
		}
		return false; // 비밀번호가 일치않으면 false반환
	}

	@Override
	public boolean Singup(UserVo user) {
		String id = user.getId();
		UserVo tmp = userDao.getUser(id);
		System.out.println(tmp);
		if(tmp == null) {
			userDao.insertUser(user);
			return true;
		}
		return false;
	}

}
