package com.jjb.model;

public class UserVO {
	private String userid;
    private String userpw;
    private String username;
    private String nickname;
    private String email;
    private String addr1;
    private String addr2;
    private String addr3;
    private String rdate;
    private String updatedate;
    private int point;
    private int qualify;
    private String profileImg;
    
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public int getQualify() {
		return qualify;
	}
	public void setQualify(int qualify) {
		this.qualify = qualify;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", nickname=" + nickname
				+ ", email=" + email + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", rdate=" + rdate
				+ ", updatedate=" + updatedate + ", point=" + point + ", qualify=" + qualify + ", profileImg="
				+ profileImg + "]";
	}
}
