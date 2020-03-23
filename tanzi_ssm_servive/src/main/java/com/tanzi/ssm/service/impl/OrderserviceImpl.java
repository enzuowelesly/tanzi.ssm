package com.tanzi.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.tanzi.ssm.dao.IOdersDao;
import com.tanzi.ssm.domain.Orders;
import com.tanzi.ssm.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderserviceImpl implements IOderService {
    @Autowired
    private IOdersDao iOdersDao;
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return iOdersDao.findAll();
    }

    @Override
    public Orders findById(Integer ordersId) throws Exception {
        Orders orders=iOdersDao.findById(ordersId);
//        System.out.println("12222222222222222222222222222222222222222222222");
//        System.out.println(orders);

        return iOdersDao.findById(ordersId);
    }
}
