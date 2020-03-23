package com.tanzi.ssm.dao;

import com.tanzi.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from  role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoled (Integer id )throws Exception;
    @Select("select * from permission")
    List<Permission> findAll()throws Exception;
    @Insert("insert into permission (permissionName,url)values(#{permissionName},#{url})")
    void save(Permission permission)throws Exception;
}
