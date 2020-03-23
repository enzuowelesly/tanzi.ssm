package com.tanzi.ssm.service.impl;

import com.tanzi.ssm.dao.IRoleDao;
import com.tanzi.ssm.domain.Permission;
import com.tanzi.ssm.domain.Role;
import com.tanzi.ssm.service.IRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleserviceImpl implements IRoleservice {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();

    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findOrtherPermissions(Integer roleId) throws Exception {
        return roleDao.findOrtherPermissions(roleId);
    }

    @Override
    public Role findById(Integer roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionids) throws Exception {
        for (Integer permissionid : permissionids) {
            roleDao.addPermissionToRole(roleId,permissionid);
        }
    }
}
