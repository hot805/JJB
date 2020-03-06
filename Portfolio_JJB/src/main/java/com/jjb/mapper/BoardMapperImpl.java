package com.jjb.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

@Repository
public class BoardMapperImpl implements BoardMapper{

	@Inject //Autowired도 가능
	private SqlSession sqlSession;	
	private static final String namespace="com.jjb.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> boardlist(String name) throws Exception {
		List list = sqlSession.selectList(namespace+".boardlist", name);
		return list;
	}

	@Override
	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage",paramMap);
		return list;
	}

	@Override
	public int boardCount(Map<String, Object> paramMap) throws Exception {
		System.out.println("inpl cri = " + paramMap.get("cri"));
		int count = sqlSession.selectOne(namespace+".boardCount",paramMap);
		System.out.println("inpl count = "+count);
		return count;
	}

	@Override
	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception {
		BoardVO detail = sqlSession.selectOne(namespace+".boardDetail",paramMap);
		return detail;
	}

	@Override
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".repBoardListPage",paramMap);
		return list;
	}

	@Override
	public int RepCount(Map<String, Object> paramMap) throws Exception {
		System.out.println("repCount "+paramMap );
		int total = sqlSession.selectOne(namespace+".RepCount",paramMap);
		return total;
	}

	@Override
	public void repWrite(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("최종확인 댓글 확인 : "+paramMap);
		sqlSession.insert(namespace+".repWrite", paramMap);
	}

	@Override
	public void repModify(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".repModify", paramMap);
	}

	@Override
	public void repDelete(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".repDelete",paramMap);
	}

	@Override
	public void boardWrite(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("최종확인:"+paramMap);
		sqlSession.insert(namespace+".boardWrite", paramMap);
		
	}

	@Override
	public void boardModify(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".boardModify", paramMap);
	}

	@Override
	public void boardDelete(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".boardDelete", paramMap);
	}

	@Override
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".ModifyList",paramMap);
		
	}

	@Override
	public void addViewCnt(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".addViewCnt", paramMap);
	}

	@Override
	public int likeck(Map<String, Object> likeck) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".likeck", likeck);
	}

	@Override
	public void like(Map<String, Object> like) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".like", like);
		
	}

	@Override
	public void unlike(Map<String, Object> like) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(like);
		sqlSession.delete(namespace+".unlike",like);
	}
	
	@Override
	public int followck(Map<String, Object> followck) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".followck", followck);
	}

	@Override
	public void searchKeyword(Map<String, Object> search) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".searchKeyword",search);
	}

	@Override
	public List<String> RecentKeyword() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".RecentKeyword");
	}

	@Override
	public List<BoardVO> orderRecipe(int order) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("여기"+order);
		return sqlSession.selectList(namespace+".orderRecipe", order);
	}

	@Override
	public List<BoardVO> orderRecipe_like() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".orderRecipe_like");
	}

	@Override
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".likePaging",paramMap);
	}

	@Override
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".boardWriteBasic",paramMap);
	}

	@Override
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".boardModifyBasic",paramMap);
	}

	@Override
	public void help_answer(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".help_answer",board);
	}
}
