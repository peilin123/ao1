package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Department;
import com.bwf.entity.Role;
import com.bwf.entity.User;
import com.bwf.service.IDepartmentService;
import com.bwf.service.IRoleService;
import com.bwf.service.IUserService;


@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	IDepartmentService departmentService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IRoleService roleService;
	
	@RequestMapping("show")
	public String show(ModelMap modelMap ){
		List<Department> allDepartment=departmentService.getAllSimpleDepartment();
		modelMap.addAttribute("allDepartment", allDepartment);
		return "department/show";
	}
	
	@GetMapping("add")
	public String add(ModelMap modelMap){
		List<Department> allDepartment=departmentService.getAllSimpleDepartment();
		modelMap.addAttribute("allDepartment", allDepartment);
		List<User> allUser=userService.getAllUsers();
		modelMap.addAttribute("allUser", allUser);
		return "department/add";
	}
	
	@GetMapping("doAdd")
	public String doAdd(Department department){
//		System.out.println(department.getDepartmentName() +
//		";"+ department.getPid()+";"+department.getUserId());
		departmentService.add(department);
		return "redirect:/department/show";
	}
	
	@GetMapping("edit")
	public String edit(Integer departmentId,ModelMap modelMap){
		Department department=departmentService.getDepartmentByDepartmentId(departmentId);
		modelMap.addAttribute("department", department);
		List<Department> allDepartment=departmentService.getAllSimpleDepartment();
		modelMap.addAttribute("allDepartment", allDepartment);
		List<User> allUser=userService.getAllUsers();
		modelMap.addAttribute("allUser", allUser);
		return "department/edit";
	}
	
	@GetMapping("doEdit")
	public String doEdit(Department department){
//		System.out.println(department.getDepartmentId()+";"+department.getDepartmentName() +
//		";"+ department.getPid()+";"+department.getUserId());
		
		departmentService.doEdit(department);
		
		return "redirect:/department/show";
	}
	
	@GetMapping("delete")
	public String delete(Department department){
		System.out.println(department.getDepartmentId()+";"+department.getDepartmentName() +
		";"+ department.getPid()+";"+department.getUserId());
		
		departmentService.delete(department);
		
		return "redirect:/department/show";
	}
	
	@GetMapping("detail")
	public String detail(Integer departmentId,ModelMap modelMap){
		Department department=departmentService.getDepartmentByDepartmentId(departmentId);
		modelMap.addAttribute("department", department);
		List<Department> allDepartment=departmentService.getAllSimpleDepartment();
		modelMap.addAttribute("allDepartment", allDepartment);
		List<Role> roles=roleService.getRolesByDepartmentId(department.getDepartmentId());
		modelMap.addAttribute("roles", roles);
		return "department/detail";
	}

}
