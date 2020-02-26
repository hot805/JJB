package com.jjb.model;

public class RepBoardVO {
	private int rno;
	private int bno;
	private String userid;
	private String nickname;
	private String content;
	private String regdate;
	private String udate;
	private int likeno;
	private String section;
	
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public int getLikeno() {
		return likeno;
	}
	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}
	
	
	@Override
	public String toString() {
		return "RepBoardVO [rno=" + rno + ", bno=" + bno + ", userid=" + userid + ", nickname=" + nickname
				+ ", content=" + content + ", regdate=" + regdate + ", udate=" + udate + ", likeno=" + likeno
				+ ", section=" + section + "]";
	}
	
}
