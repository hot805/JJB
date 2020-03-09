package com.jjb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjb.mapper.BoardMapper;
import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bm;
	
	// 게시판 리스트
	@Override
	public List<BoardVO> boardlist(String name) throws Exception {
		return bm.boardlist(name);
	}
	
	// 게시판 리스트 페이징 처리
	@Override
	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception {
		return bm.boardListPaging(paramMap);
	}
	
	// 전체 페이지 개수
	@Override
	public int boardCount(Map<String, Object> paramMap) throws Exception {
		return bm.boardCount(paramMap);
	}
	
	//boardDetailList
	@Override
	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception {
		return bm.boardDetail(paramMap);
	}
	
	// 게시판 댓글 조회
	@Override
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception {
		return bm.repBoardList(paramMap);
	}
	
	// 댓글 갯수 조회
	@Override
	public int RepCount(Map<String, Object> paramMap) throws Exception {
		return bm.RepCount(paramMap);
	}
	
	// 댓글 작성
	@Override
	public void repWrite(Map<String, Object> paramMap) throws Exception {
		bm.repWrite(paramMap);
	}
	
	// 댓글 수정
	@Override
	public void repModify(Map<String, Object> paramMap) throws Exception {
		bm.repModify(paramMap);
	}
	
	// 댓글 삭제
	@Override
	public void repDelete(Map<String, Object> paramMap) throws Exception {
		bm.repDelete(paramMap);
		
	}
	
	//게시판 글쓰기
	@Override
	public void boardWrite(Map<String, Object> paramMap) throws Exception {
		bm.boardWrite(paramMap);
	}
	
	//게시판 글수정
	@Override
	public void boardModify(Map<String, Object> paramMap) throws Exception {
		bm.boardModify(paramMap);
	}
	
	//게시판 글삭제
	@Override
	public void boardDelete(Map<String, Object> paramMap) throws Exception {
		bm.boardDelete(paramMap);
	}
	
	// 게시판 수정페이지 리스트
	@Override
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception {
		return bm.ModifyList(paramMap);
	}
	
	// 조회수 상승
	@Override
	public void addViewCnt(Map<String, Object> paramMap) throws Exception {
		bm.addViewCnt(paramMap);
	}
	
	// 좋아요 조회
	@Override
	public int likeck(Map<String, Object> likeck) throws Exception {
		return bm.likeck(likeck);
	}
	
	// 좋아요
	@Override
	public void like(Map<String, Object> like) throws Exception {
		bm.like(like);
	}
	
	// 좋아요 취소
	@Override
	public void unlike(Map<String, Object> like) throws Exception {
		bm.unlike(like);
	}
	
	// 팔로우 조회
	@Override
	public int followck(Map<String, Object> followck) throws Exception {
		return bm.followck(followck);
	}
	
	// 키워드 검색
	@Override
	public void searchKeyword(Map<String, Object> search) throws Exception {
		bm.searchKeyword(search);
	}
	
	// 최근 검색 키워드
	@Override
	public List<String> RecentKeyword() throws Exception {
		return bm.RecentKeyword();
	}
	
	// 레시피 조회순, 최신순
	@Override
	public List<BoardVO> orderRecipe(int order) throws Exception {
		return bm.orderRecipe(order);
	}
	
	// 레시피 좋아요순
	@Override
	public List<BoardVO> orderRecipe_like() throws Exception {
		return bm.orderRecipe_like();
	}
	
	// 레시피 좋아요순 paging
	@Override
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception {
		return bm.likePaging(paramMap);
	}
	
	// 게시판 글작성_기본
	@Override
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception {
		bm.boardWriteBasic(paramMap);
	}
	
	//게시판 변경_기본
	@Override
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception {
		bm.boardModifyBasic(paramMap);;
	}
	
	// 고객센터 답변 수정 및 작성
	@Override
	public void help_answer(BoardVO board) throws Exception {
		bm.help_answer(board);
	}
}
