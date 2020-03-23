package com.tanzi.ssm.service.impl;

import com.tanzi.ssm.dao.IProductDao;
import com.tanzi.ssm.domain.Product;
import com.tanzi.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {

        List<Product> li =productDao.findAll();
        for (Product product : li) {
            System.out.println(product);

        }
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
