package kr.green.spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring2.dao.UserDao;
import kr.green.spring2.vo.UserVo;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserVo isUser(String id, String pw) {
		UserVo user = userDao.getUser(id);
		// 입력한 id가 DB에 일치하는 id가 없으면 false반환
		if(user == null) {			
			return null;
		}
		// 회원정보가 null이 아니면서 암호화된 비밀번호와 일치하면 true반환
		if(user != null && passwordEncoder.matches(pw, user.getPw())) {
			return user;
		}
		return null; // 비밀번호가 불일치
	}

	@Override
	public boolean Singup(UserVo user) {
		String id = user.getId();
		UserVo tmp = userDao.getUser(id);
		System.out.println(tmp);
		if(tmp == null) {
			String encPw = passwordEncoder.encode(user.getPw());
			user.setPw(encPw);
			userDao.insertUser(user);
			return true;
		}
		return false;
	}

}
