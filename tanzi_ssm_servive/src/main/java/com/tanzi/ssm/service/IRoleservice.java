package com.tanzi.ssm.service;

import com.tanzi.ssm.domain.Permission;
import com.tanzi.ssm.domain.Role;

import java.util.List;

public interface IRoleservice {
    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    List<Permission> findOrtherPermissions(Integer roleId)throws Exception;

    Role findById(Integer roleId)throws Exception;

    void addPermissionToRole(Integer roleId, Integer[] permissionids)throws Exception;
}
