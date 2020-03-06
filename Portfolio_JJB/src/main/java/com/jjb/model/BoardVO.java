package com.jjb.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int bno;
	private String profileImg;
	private String title;
	private String content;
	private String userid;
	private String nickname;
	private String regdate;
	private String udate;
	private int cnt;
	private String filename;
	private String imgname;
	private String section;
	private String contentImg;
	private int countImg;
	private String category;
	private String answer;
	private int orderno;
	private String duration;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getContentImg() {
		return contentImg;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public int getCountImg() {
		return countImg;
	}

	public void setCountImg(int countImg) {
		this.countImg = countImg;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", profileImg=" + profileImg + ", title=" + title + ", content=" + content
				+ ", userid=" + userid + ", nickname=" + nickname + ", regdate=" + regdate + ", udate=" + udate
				+ ", cnt=" + cnt + ", filename=" + filename + ", imgname=" + imgname + ", section=" + section
				+ ", contentImg=" + contentImg + ", countImg=" + countImg + ", category=" + category + ", answer="
				+ answer + ", orderno=" + orderno + ", duration=" + duration + "]";
	}

}