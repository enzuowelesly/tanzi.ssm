package com.tanzi.ssm.service;

import com.tanzi.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll() throws Exception;

    void save(Permission permission)throws  Exception;
}
