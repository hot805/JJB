package com.jjb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjb.mapper.UserMapper;
import com.jjb.model.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper um;
	
	@Override
	public UserVO login(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return um.login(user);
	}

	@Override
	public void signUp(UserVO user) throws Exception {
		um.signUp(user);
	}

	@Override
	public String checkID(String userid) throws Exception {
		return um.checkID(userid);
	}	

	@Override
	public String checkPW(String userid) throws Exception {
		return um.checkPW(userid);
	}

	@Override
	public String checkNick(String nickname) throws Exception {
		// TODO Auto-generated method stub
		return um.checkNick(nickname);
	}

	@Override
	public UserVO InfoFromId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return um.InfoFromId(userid);
	}

	@Override
	public void changeInfo(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		um.changeInfo(user);
	}

	@Override
	public void changePw(String newPw, String userid) throws Exception {
		// TODO Auto-generated method stub
		um.changePw(newPw, userid);
		
	}

	@Override
	public void deleteUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		um.deleteUser(userid);
	}


}
