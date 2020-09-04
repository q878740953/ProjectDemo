package com.ssm.service.impl;

import com.ssm.dao.OrdersDao;
import com.ssm.domain.Order;
import com.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Order> findAll() {
        return ordersDao.findAll();
    }
}
