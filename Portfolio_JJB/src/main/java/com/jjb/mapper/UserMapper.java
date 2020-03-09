package com.jjb.mapper;

import java.util.List;

import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

public interface UserMapper {
	//로그인
	public UserVO login(UserVO user) throws Exception;
	
	//회원가입
	public void signUp(UserVO user) throws Exception;
	
	//아이디 확인
	public String checkID(String userid) throws Exception;
	
	//닉네임 확인
	public String checkNick(String nickname) throws Exception;
	
	//비밀번호 확인
	public String checkPW(String userid) throws Exception;
	
	//아이디 기준으로 찾는 정보
	public UserVO InfoFromId(String userid) throws Exception;
	
	//프로필_쉐프 수정
	public void changeChefInfo(UserVO user) throws Exception;
	
	//프로필, 닉네임, 이메일, 주소 수정
	public void changeInfo(UserVO user) throws Exception;
	
	//비밀변호 변경
	public void changePw(String newPw, String userid) throws Exception;
	
	//계정 탈퇴
	public void deleteUser(String userid) throws Exception;

	//유저 리스트
	public List<UserVO> userList(Criteria cri) throws Exception;
	
	//유저 카운트
	public int userCount() throws Exception;
	
	//쉐프 권한 부여
	public void grantUser(UserVO user) throws Exception;
	
	//쉐프 리스트에 추가
	public void insertChef(UserVO user) throws Exception;
	
	//쉐프 권한 삭제
	public void revokeUser(UserVO user) throws Exception;
	
	//쉐프 리스트에서 삭제
	public void deleteChef(UserVO user) throws Exception;
}
