package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.DepartmentMapper;
import com.bwf.entity.Department;
import com.bwf.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
	@Autowired
	com.bwf.dao.DepartmentMapper departmentMapper;

	@Override
	public List<Department> getAll() {
		
		return departmentMapper.getAll();
	}

	@Override
	public List<Department> getAllSimpleDepartment() {
		// TODO Auto-generated method stub
		return departmentMapper.getAllSimpleDepartment();
	}

	@Override
	public void add(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.add(department);
	}

	@Override
	public Department getDepartmentByDepartmentId(Integer departmentId) {
		// TODO Auto-generated method stub
		return departmentMapper.getDepartmentByDepartmentId(departmentId);
	}

	@Override
	public void doEdit(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.doEdit(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.delete(department);
	}

}
