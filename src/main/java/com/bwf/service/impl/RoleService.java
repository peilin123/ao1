package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.entity.Role;
import com.bwf.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	com.bwf.dao.RoleMapper roleMapper;

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.getAllRoles();
	}

	@Override
	public List<Role> getRolesByDepartmentId(Integer departmentId) {
		// TODO Auto-generated method stub
		return roleMapper.getRolesByDepartmentId(departmentId);
	}

}
