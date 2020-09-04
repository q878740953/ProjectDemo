package com.ssm.controller;

import com.ssm.domain.Order;
import com.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService ordersService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Order> orderList = ordersService.findAll();
        model.addAttribute("orderList", orderList);
        return "orders-list";
    }
}
