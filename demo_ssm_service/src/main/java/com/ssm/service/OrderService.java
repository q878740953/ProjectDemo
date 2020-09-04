package com.ssm.service;

import com.ssm.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll(int pageNum, int pageSize);
}
