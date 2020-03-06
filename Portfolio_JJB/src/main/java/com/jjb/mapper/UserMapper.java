package com.jjb.mapper;

import java.util.List;

import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

public interface UserMapper {
	public UserVO login(UserVO user) throws Exception;
	
	public void signUp(UserVO user) throws Exception;
	
	public String checkID(String userid) throws Exception;
	
	public String checkNick(String nickname) throws Exception;
	
	public String checkPW(String userid) throws Exception;
	
	public UserVO InfoFromId(String userid) throws Exception;
	
	public void changeChefInfo(UserVO user) throws Exception;
	
	public void changeInfo(UserVO user) throws Exception;
	
	public void changePw(String newPw, String userid) throws Exception;
	
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
