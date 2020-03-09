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
	
	// 게시판 리스트
	@Override
	public List<BoardVO> boardlist(String name) throws Exception {
		List list = sqlSession.selectList(namespace+".boardlist", name);
		return list;
	}
	
	// 게시판 리스트 페이징 처리
	@Override
	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage",paramMap);
		return list;
	}
	
	// 전체 페이지 개수
	@Override
	public int boardCount(Map<String, Object> paramMap) throws Exception {
		int count = sqlSession.selectOne(namespace+".boardCount",paramMap);
		return count;
	}
	
	//boardDetailList
	@Override
	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception {
		BoardVO detail = sqlSession.selectOne(namespace+".boardDetail",paramMap);
		return detail;
	}
	
	// 게시판 댓글 조회
	@Override
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".repBoardListPage",paramMap);
		return list;
	}
	
	// 댓글 갯수 조회
	@Override
	public int RepCount(Map<String, Object> paramMap) throws Exception {
		int total = sqlSession.selectOne(namespace+".RepCount",paramMap);
		return total;
	}
	
	// 댓글 작성
	@Override
	public void repWrite(Map<String, Object> paramMap) throws Exception {
		sqlSession.insert(namespace+".repWrite", paramMap);
	}
	
	// 댓글 수정
	@Override
	public void repModify(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".repModify", paramMap);
	}
	
	// 댓글 삭제
	@Override
	public void repDelete(Map<String, Object> paramMap) throws Exception {
		sqlSession.delete(namespace+".repDelete",paramMap);
	}
	
	//게시판 글쓰기
	@Override
	public void boardWrite(Map<String, Object> paramMap) throws Exception {
		sqlSession.insert(namespace+".boardWrite", paramMap);
		
	}
	
	//게시판 글수정
	@Override
	public void boardModify(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".boardModify", paramMap);
	}
	
	//게시판 글삭제
	@Override
	public void boardDelete(Map<String, Object> paramMap) throws Exception {
		sqlSession.delete(namespace+".boardDelete", paramMap);
	}
	
	// 게시판 수정페이지 리스트
	@Override
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne(namespace+".ModifyList",paramMap);
		
	}
	
	// 조회수 상승
	@Override
	public void addViewCnt(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".addViewCnt", paramMap);
	}
	
	// 좋아요 조회
	@Override
	public int likeck(Map<String, Object> likeck) throws Exception {
		return sqlSession.selectOne(namespace+".likeck", likeck);
	}
	
	// 좋아요
	@Override
	public void like(Map<String, Object> like) throws Exception {
		sqlSession.insert(namespace+".like", like);
		
	}
	
	// 좋아요 취소
	@Override
	public void unlike(Map<String, Object> like) throws Exception {
		sqlSession.delete(namespace+".unlike",like);
	}
	
	// 팔로우 조회
	@Override
	public int followck(Map<String, Object> followck) throws Exception {
		return sqlSession.selectOne(namespace+".followck", followck);
	}
	
	// 키워드 검색
	@Override
	public void searchKeyword(Map<String, Object> search) throws Exception {
		sqlSession.insert(namespace+".searchKeyword",search);
	}
	
	// 최근 검색 키워드
	@Override
	public List<String> RecentKeyword() throws Exception {
		return sqlSession.selectList(namespace+".RecentKeyword");
	}
	
	// 레시피 조회순, 최신순
	@Override
	public List<BoardVO> orderRecipe(int order) throws Exception {
		return sqlSession.selectList(namespace+".orderRecipe", order);
	}
	
	// 레시피 좋아요순
	@Override
	public List<BoardVO> orderRecipe_like() throws Exception {
		return sqlSession.selectList(namespace+".orderRecipe_like");
	}
	
	// 레시피 좋아요순 paging
	@Override
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList(namespace+".likePaging",paramMap);
	}
	
	// 게시판 글작성_기본
	@Override
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception {
		sqlSession.insert(namespace+".boardWriteBasic",paramMap);
	}
	
	//게시판 변경_기본
	@Override
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".boardModifyBasic",paramMap);
	}
	
	// 고객센터 답변 수정 및 작성
	@Override
	public void help_answer(BoardVO board) throws Exception {
		sqlSession.update(namespace+".help_answer",board);
	}
}
