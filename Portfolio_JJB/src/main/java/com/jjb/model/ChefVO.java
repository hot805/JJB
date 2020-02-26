package com.jjb.model;

public class ChefVO {
	private int rownum;
	private String userid;
	private String nickname;
	private int followno;
	private int tableno;
	private String regdate;
	private char follow_check;
	private String profileImg;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
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
	public int getFollowno() {
		return followno;
	}
	public void setFollowno(int followno) {
		this.followno = followno;
	}
	public int getTableno() {
		return tableno;
	}
	public void setTableno(int tableno) {
		this.tableno = tableno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public char getFollow_check() {
		return follow_check;
	}
	public void setFollow_check(char follow_check) {
		this.follow_check = follow_check;
	}	
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	@Override
	public String toString() {
		return "ChefVO [rownum=" + rownum + ", userid=" + userid + ", nickname=" + nickname + ", followno=" + followno
				+ ", tableno=" + tableno + ", regdate=" + regdate + ", follow_check=" + follow_check + ", profileImg="
				+ profileImg + "]";
	}
}
