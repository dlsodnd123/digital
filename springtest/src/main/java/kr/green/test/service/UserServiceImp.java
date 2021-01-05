package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.UserDao;
import kr.green.test.vo.UserVo;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public String getEmail(String id) {
		UserVo user = userDao.getUser(id);
		// 아이디와 일치하는 정보가 없으면
		if(user == null) {
			return null;
		}
		// 아이디와 일치하는 회원이 있으면,
		return user.getEmail();
	}

	@Override
	public UserVo getUser(String id) {
		UserVo user = userDao.getUser(id);
		return user;
	}

	@Override
	public UserVo isUser(String id, String pw) {
		UserVo user = userDao.getUser(id);
		// 아이디와 일치하는 정보가 없으면
		if(user == null) {
			return null; // 회원 아님
		}
		// 아이디와 일치하는 화원정보가 있으면 비밀번호를 비교하여 확인
		//if(passwordEncoder.matches(pw, user.getPw())) {
		System.out.println(user);
		if(user.getPw().equals(pw)) {
			return user; // 비밀번호가 같아서 회원
		}
		return null; // 비밀번호가 달라서 회원 아님
	}

	@Override
	public boolean signup(UserVo user) {
		UserVo tmp = userDao.getUser(user.getId());
		// 이미 가입된 회원이면 회원가입 진행불가
		if(tmp != null) {
			return false;
		}
		// 비밀번호 암호화 과정
		// 입력받은 비밀번호 가져오기
		String pw = user.getPw();
		// 입력받은 비밀번호 암호화
		String encodePw = passwordEncoder.encode(pw);
		// 회원 비밀번호를 암호화된 비밀번호로 수정
		user.setPw(encodePw);
		userDao.insertUser(user);
		return true;
	}
}
