package com.bwf.service;

import java.util.List;

import com.bwf.entity.Department;

public interface IDepartmentService {

	List<Department> getAll();

	List<Department> getAllSimpleDepartment();

	void add(Department department);

	Department getDepartmentByDepartmentId(Integer departmentId);

	void doEdit(Department department);

	void delete(Department department);

}
