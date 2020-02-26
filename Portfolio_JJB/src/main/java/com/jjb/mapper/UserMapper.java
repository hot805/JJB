package com.jjb.mapper;

import com.jjb.model.UserVO;

public interface UserMapper {
	public UserVO login(UserVO user) throws Exception;
	
	public void signUp(UserVO user) throws Exception;
	
	public String checkID(String userid) throws Exception;
	
	public String checkNick(String nickname) throws Exception;
	
	public String checkPW(String userid) throws Exception;
	
	public UserVO InfoFromId(String userid) throws Exception;
	
	public void changeInfo(UserVO user) throws Exception;
	
	public void changePw(String newPw, String userid) throws Exception;
	
	public void deleteUser(String userid) throws Exception;

}
