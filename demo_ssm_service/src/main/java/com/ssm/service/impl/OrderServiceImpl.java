package com.ssm.service.impl;
import com.github.pagehelper.PageHelper;
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
    public List<Order> findAll(int pageNum, int pageSize) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return ordersDao.findAll();
    }
}
