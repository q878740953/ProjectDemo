package com.ssm.service;

import com.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    // 查询所有订单信息
    List<Product> finAll() throws Exception;
}
