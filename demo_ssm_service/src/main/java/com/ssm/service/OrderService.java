package com.ssm.service;

import com.ssm.domain.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
}
