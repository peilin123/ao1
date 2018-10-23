package com.bwf.entity;

public class AttendanceSign {
	private Integer signInId;
	private Integer userId;
	private String signInTime;
	private String signInComment;
	private String signOutTime;
	private String signOutComment;
	private String dateString;
	
	

	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Integer getSignInId() {
		return signInId;
	}
	public void setSignInId(Integer signInId) {
		this.signInId = signInId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getSignInTime() {
		return signInTime;
	}
	public void setSignInTime(String signInTime) {
		this.signInTime = signInTime;
	}
	public String getSignInComment() {
		return signInComment;
	}
	public void setSignInComment(String signInComment) {
		this.signInComment = signInComment;
	}
	public String getSignOutTime() {
		return signOutTime;
	}
	public void setSignOutTime(String signOutTime) {
		this.signOutTime = signOutTime;
	}
	public String getSignOutComment() {
		return signOutComment;
	}
	public void setSignOutComment(String signOutComment) {
		this.signOutComment = signOutComment;
	}
	

}
