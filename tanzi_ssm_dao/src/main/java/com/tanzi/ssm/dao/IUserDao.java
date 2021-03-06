package com.tanzi.ssm.dao;

import com.tanzi.ssm.domain.Role;
import com.tanzi.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserDao{
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property ="id",column = "id"),
            @Result(property ="username",column = "username"),
            @Result(property ="email",column = "email"),
            @Result(property ="password",column = "password"),
            @Result(property ="phoneNum",column = "phoneNum"),
            @Result(property ="status",column = "status"),
            @Result(property ="roles",column = "id",javaType = java.util.List.class,many = @Many (select="com.tanzi.ssm.dao.IRoleDao.findByUserId"))

})
    public UserInfo findByUsername (String username)throws Exception;



    @Select("select * from users")
    List<UserInfo> fndAll() throws Exception;
    @Insert("insert into users (email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property ="id",column = "id"),
            @Result(property ="username",column = "username"),
            @Result(property ="email",column = "email"),
            @Result(property ="password",column = "password"),
            @Result(property ="phoneNum",column = "phoneNum"),
            @Result(property ="status",column = "status"),
            @Result(property ="roles",column = "id",javaType = java.util.List.class,many = @Many (select="com.tanzi.ssm.dao.IRoleDao.findByUserId"))

    })
   public UserInfo findById(Integer id) throws Exception;
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(Integer userId)throws Exception;
    @Insert("insert into users_role (userId,roleId)values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId,@Param("roleId") Integer roleId) throws Exception;
}
