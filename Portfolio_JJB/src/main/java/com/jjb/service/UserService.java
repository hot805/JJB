package com.jjb.service;

import com.jjb.model.UserVO;

public interface UserService {
	public UserVO login(UserVO user) throws Exception;
	
	public void signUp(UserVO user) throws Exception;
	
	public String checkID(String userid) throws Exception;
	
	public String checkNick(String nickname) throws Exception;
	
	public String checkPW(String userid) throws Exception;
	
	//닉네임 기준으로 찾는 정보
	public UserVO InfoFromId(String userid) throws Exception;
	
	//닉네임, 이메일, 주소 수정
	public void changeInfo(UserVO user) throws Exception;
	
	//비밀번호 변경
	public void changePw(String newPw, String userid) throws Exception;
	
	//계정 탈퇴
	public void deleteUser(String userid) throws Exception;
}
