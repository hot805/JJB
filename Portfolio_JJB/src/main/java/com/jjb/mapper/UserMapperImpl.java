package com.jjb.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.jjb.mapper.UserMapper";

	//로그인
	@Override
	public UserVO login(UserVO userVO) throws Exception {
		UserVO user= sqlSession.selectOne(namespace+".login",userVO);
		return user;
	}
	
	//회원가입
	@Override
	public void signUp(UserVO user) throws Exception {
		sqlSession.insert(namespace+".signUp", user);		
	}

	//아이디 확인
	@Override
	public String checkID(String userid) throws Exception {
		String checkedid = sqlSession.selectOne(namespace+".checkID",userid);
		return checkedid;
	}

	//닉네임 확인
	@Override
	public String checkNick(String nickname) throws Exception {
		String checkednick = sqlSession.selectOne(namespace+".checkNick",nickname);
		return checkednick;
	}

	//비밀번호 확인
	@Override
	public String checkPW(String userid) throws Exception {
		String PwForCk = sqlSession.selectOne(namespace+".checkPW",userid);
		return PwForCk;
	}

	//아이디 기준을 찾는 정보
	@Override
	public UserVO InfoFromId(String userid) throws Exception {
		UserVO user = sqlSession.selectOne(namespace+".InfoFromId",userid); 
		return user;
	}

	//프로필, 닉네임, 이메일, 주소 수정
	@Override
	public void changeInfo(UserVO user) throws Exception {
		sqlSession.update(namespace+".changeInfo",user);
	}
	
	//프로필_쉐프 수정
	@Override
	public void changeChefInfo(UserVO user) throws Exception {
		sqlSession.update(namespace+".changeChefInfo",user);
	}

	//비밀번호 변경
	@Override
	public void changePw(String newPw, String userid) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("newPw", newPw);
		paramMap.put("userid", userid);
		sqlSession.update(namespace+".changePw",paramMap);
		
	}

	//계정 탈퇴
	@Override
	public void deleteUser(String userid) throws Exception {
		sqlSession.delete(namespace+".deleteUser",userid);
	}
	
	//유저 리스트
	@Override
	public List<UserVO> userList(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".userList",cri);
		return list;
	}
	
	//쉐프 권한 부여
	@Override
	public void grantUser(UserVO user) throws Exception {
		sqlSession.update(namespace+".grantUser",user);
	}
	
	//쉐프 리스트에 추가
	@Override
	public void insertChef(UserVO user) throws Exception {
		sqlSession.insert(namespace+".insertChef",user);
	}
	
	//쉐프 권한 삭제
	@Override
	public void revokeUser(UserVO user) throws Exception {
		sqlSession.update(namespace+".revokeUser",user);
	}
	
	//쉐프 리스트에서 삭제
	@Override
	public void deleteChef(UserVO user) throws Exception {
		sqlSession.delete(namespace+".deleteChef",user);
	}

	//유저 카운트
	@Override
	public int userCount() throws Exception {
		return sqlSession.selectOne(namespace+".UserCount");
	}
}
