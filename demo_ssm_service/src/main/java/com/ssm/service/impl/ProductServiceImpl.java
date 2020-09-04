package com.ssm.service.impl;

import com.ssm.dao.ProductDao;
import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao; // spring 自动注入
    @Override
    public List<Product> finAll() throws Exception{
        return productDao.finAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }
}
