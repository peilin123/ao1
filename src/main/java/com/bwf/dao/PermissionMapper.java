package com.bwf.dao;

import java.util.List;

import com.bwf.entity.Permission;

public interface PermissionMapper {

	List<Permission> getAllPermissions();

	List<Permission> getPermissionsByRoleId(Integer roleId);

}
