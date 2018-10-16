package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Permission;
import com.bwf.entity.Role;
import com.bwf.service.IPermissionService;
import com.bwf.service.IRoleService;

@Controller
@RequestMapping("permission")
public class PermissionController {
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IPermissionService permissionService;
	
	@GetMapping("manage")
	public String getPermission(Integer roleId ,ModelMap modelMap){
		if( roleId == null ) {
			roleId = 2;
		}
		
		// 获取当前请求的角色所拥有的权限的编号的集合
		List<Permission> currentRolePermissions = permissionService.getPermissionsByRoleId(roleId);
		List<Integer> currentRolePermissionIds = permissionService.getPermissionIdFormPermissionList(currentRolePermissions);
 		
		// 获取所有角色的集合 , 添加到 modelMap中去
		List<Role> allRoles = roleService.getAllRoles();
		List<Permission> allPermissions = permissionService.getAllPermissions();
		
		modelMap.addAttribute("allRoles", allRoles);
		modelMap.addAttribute("allPermissions", allPermissions);
		modelMap.addAttribute("currentRolePermissionIds", currentRolePermissionIds);
		modelMap.addAttribute("roleId", roleId);
		
		
		return "permission/manage";
	}
	
	@GetMapping("save")
	public void PermissionSave(){
		
	}

}
