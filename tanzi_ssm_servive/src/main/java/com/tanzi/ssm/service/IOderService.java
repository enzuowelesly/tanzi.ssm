package com.tanzi.ssm.service;

import com.tanzi.ssm.domain.Orders;

import java.util.List;

public interface IOderService {
    List<Orders> findAll(int page,int size) throws Exception;
    Orders findById(Integer ordersId) throws Exception;

}
