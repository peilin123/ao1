package com.bwf.entity;

public class AffairChain {
	private Integer affairChainId;
	
	private Integer affairId;
	
	private Integer affairChainOrder;
	
	private Integer affairChainStatus;
	
	private String affairChainComment;
	
	private Integer approver;
	
	private User approver1;

	public User getApprover1() {
		return approver1;
	}

	public void setApprover1(User approver1) {
		this.approver1 = approver1;
	}

	public Integer getAffairChainId() {
		return affairChainId;
	}

	public void setAffairChainId(Integer affairChainId) {
		this.affairChainId = affairChainId;
	}

	public Integer getAffairId() {
		return affairId;
	}

	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}

	public Integer getAffairChainOrder() {
		return affairChainOrder;
	}

	public void setAffairChainOrder(Integer affairChainOrder) {
		this.affairChainOrder = affairChainOrder;
	}

	public Integer getAffairChainStatus() {
		return affairChainStatus;
	}

	public void setAffairChainStatus(Integer affairChainStatus) {
		this.affairChainStatus = affairChainStatus;
	}

	public String getAffairChainComment() {
		return affairChainComment;
	}

	public void setAffairChainComment(String affairChainComment) {
		this.affairChainComment = affairChainComment;
	}

	public Integer getApprover() {
		return approver;
	}

	public void setApprover(Integer approver) {
		this.approver = approver;
	}
}
