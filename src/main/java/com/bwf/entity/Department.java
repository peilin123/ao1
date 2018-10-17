package com.bwf.entity;

import java.util.List;

public class Department {
	
	private Integer departmentId;
	
	private String departmentName;
	
	private Integer pid;
	
	private User leader;
	
	// 部门下的所有所属员工
		private List<User> users;
	



	public Integer getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		}

	public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}
	
	
}
