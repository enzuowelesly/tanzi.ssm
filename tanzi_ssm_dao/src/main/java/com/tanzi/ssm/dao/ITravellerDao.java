package com.tanzi.ssm.dao;

import com.tanzi.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITravellerDao {
    @Select("select * from traveller where id in  (select travellerId from order_traveller where orderId=#{ordersId})")

    public List<Traveller> findById(Integer orderId) throws Exception;
}
