package com.tanzi.ssm.dao;

import com.tanzi.ssm.domain.Member;
import com.tanzi.ssm.domain.Orders;
import com.tanzi.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select ="com.tanzi.ssm.dao.IProductDao.findById")),


    })
    public List<Orders> findAll() throws  Exception;




@Select("select * from orders where id=#{ordersId}")
@Results({
        @Result(id=true,property = "id",column = "id"),
        @Result(property = "orderNum",column = "orderNum"),
        @Result(property = "orderTime",column = "orderTime"),
        @Result(property = "orderStatus",column = "orderStatus"),
        @Result(property = "peopleCount",column = "peopleCount"),
        @Result(property = "payType",column = "payType"),
        @Result(property = "orderDesc",column = "orderDesc"),
        @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select ="com.tanzi.ssm.dao.IProductDao.findById")),
        @Result(property = "member",column = "memberId",javaType = Member.class,one=@One(select="com.tanzi.ssm.dao.IMemberDao.findById")),
        @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select ="com.tanzi.ssm.dao.ITravellerDao.findById"))
})
    public Orders findById(Integer ordersId) throws  Exception;
}
