package com.jjb.Controller;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjb.mapper.UserMapper;
import com.jjb.model.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)//컴파일 할때 SpringJUnit4ClassRunner 클래스와 같이 컴파일 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//context가 어디있는지 인지 시켜주는 것

public class userTest {
	@Autowired
	private UserMapper userMapper;
	
	/*
	@Test
	public void testSignUp() throws Exception{
		UserVO user = new UserVO();
		user.setUserid("aaa1");
		user.setUserpw("111");
		user.setUsername("그린이");
		user.setEmail("aaa1@naver.com");
		user.setGender('남');
		user.setNickname("우유장수");
		user.setAddr1("사랑시");
		user.setAddr2("고백구");
		user.setAddr3("행복동");
		
		userMapper.signUp(user);
	}
	*/
	
	@Test
	public void testLog() throws Exception{
		UserVO user = new UserVO();
		user.setUserid("aaa1");
		user.setUserpw("111");
		
		UserVO result = userMapper.login(user);
		System.out.println("결과 : "+result.toString());
		
	}
	

}
