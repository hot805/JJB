package com.jjb.mapper;

import java.util.List;
import java.util.Map;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

public interface BoardMapper {
	// 게시판 리스트
	public List<BoardVO> boardlist(String name) throws Exception;

	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception;

	// 전체 페이지 개수
	public int boardCount(Map<String, Object> paramMap) throws Exception;

	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception;

	public void boardWrite(Map<String, Object> paramMap) throws Exception;

	public void boardModify(Map<String, Object> paramMap) throws Exception;

	public void boardDelete(Map<String, Object> paramMap) throws Exception;

	// 게시판 댓글 조회
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception;

	// 댓글 갯수 조회
	public int RepCount(Map<String, Object> paramMap) throws Exception;

	// 댓글 작성
	public void repWrite(Map<String, Object> paramMap) throws Exception;

	// 댓글 수정
	public void repModify(Map<String, Object> paramMap) throws Exception;

	// 댓글 삭제
	public void repDelete(Map<String, Object> paramMap) throws Exception;

	// 게시판 수정페이지 리스트
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception;

	// 조회수 상승
	public void addViewCnt(Map<String, Object> paramMap) throws Exception;

	// 좋아요 조회
	public int likeck(Map<String, Object> likeck) throws Exception;

	// 좋아요
	public void like(Map<String, Object> like) throws Exception;

	// 좋아요 취소
	public void unlike(Map<String, Object> like) throws Exception;

	// 팔로우 조회
	public int followck(Map<String, Object> followck) throws Exception;

	// 키워드 검색
	public void searchKeyword(Map<String, Object> search) throws Exception;

	// 최근 검색 키워드
	public List<String> RecentKeyword() throws Exception;
	
	// 레시피 조회순, 최신순
	public List<BoardVO> orderRecipe(int order) throws Exception; 
	
	// 레시피 좋아요순
	public List<BoardVO> orderRecipe_like() throws Exception;
	
	// 레시피 좋아요순 paging
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception;
	
	// 게시판 글작성_기본
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception;
	
	//게시판 변경_기본
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception;
	
	// 고객센터 답변 수정 및 작성
	public void help_answer(BoardVO board) throws Exception;
}
