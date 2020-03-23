package com.tanzi.ssm.service;

import com.tanzi.ssm.domain.Role;
import com.tanzi.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    public UserInfo findById(Integer id) throws Exception;

    List<Role> findOtherRoles(Integer userId)throws Exception;

    void addRoleToUser(Integer userId, Integer[] roleIds) throws Exception;
}
