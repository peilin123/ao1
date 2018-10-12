package com.bwf.entity;

public class Operate {
	private Integer operateId;
	@Override
	public String toString() {
		return "Operate [operateId=" + operateId + ", operateName=" + operateName + ", operateAction=" + operateAction
				+ ", operateUrl=" + operateUrl + ", pid=" + pid + "]";
	}
	public Integer getOperateId() {
		return operateId;
	}
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getOperateAction() {
		return operateAction;
	}
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}
	public String getOperateUrl() {
		return operateUrl;
	}
	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private String operateName;
	private String operateAction;
	private String operateUrl;
	private Integer pid;

}
