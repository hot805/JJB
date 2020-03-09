package com.jjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjb.mapper.UserMapper;
import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper um;
	
	//로그인
	@Override
	public UserVO login(UserVO user) throws Exception {
		return um.login(user);
	}
	
	//회원가입
	@Override
	public void signUp(UserVO user) throws Exception {
		um.signUp(user);
	}
	
	//아이디 확인
	@Override
	public String checkID(String userid) throws Exception {
		return um.checkID(userid);
	}

	//비밀번호 확인
	@Override
	public String checkPW(String userid) throws Exception {
		return um.checkPW(userid);
	}

	//닉네임 확인
	@Override
	public String checkNick(String nickname) throws Exception {
		return um.checkNick(nickname);
	}

	//아이디 기준으로 찾는 정보
	@Override
	public UserVO InfoFromId(String userid) throws Exception {
		return um.InfoFromId(userid);
	}
	
	//프로필, 닉네임, 이메일, 주소 수정
	@Override
	public void changeInfo(UserVO user) throws Exception {
		um.changeInfo(user);
	}
	
	//프로필_쉐프 수정
	@Transactional
	@Override
	public void changeChefInfo(UserVO user) throws Exception {
		um.changeInfo(user);
		um.changeChefInfo(user);
	}
	
	//비밀변호 변경
	@Override
	public void changePw(String newPw, String userid) throws Exception {
		um.changePw(newPw, userid);

	}
	
	//계정 탈퇴
	@Override
	public void deleteUser(String userid) throws Exception {
		um.deleteUser(userid);
	}
	
	//유저 리스트
	@Override
	public List<UserVO> userList(Criteria cri) throws Exception {
		return um.userList(cri);
	}
	
	//쉐프 권한 부여
	@Transactional
	@Override
	public void grantUser(UserVO user) throws Exception {
		um.grantUser(user);
		um.insertChef(user);
	}

	//쉐프 권한 삭제
	@Transactional
	@Override
	public void revokeUser(UserVO user) throws Exception {
		um.revokeUser(user);
		um.deleteChef(user);
	}

	//유저 카운트
	@Override
	public int userCount() throws Exception {
		return um.userCount();
	}
}
