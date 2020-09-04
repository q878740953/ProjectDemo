package com.ssm.service;

import com.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    // 查询所有订单信息
    List<Product> finAll() throws Exception;
    // 增加产品
    void save(Product product) throws Exception;
    // 根据id查询产品信息
    Product findById(int id);
}
