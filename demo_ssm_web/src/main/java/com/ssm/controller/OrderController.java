package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Order;
import com.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService ordersService;
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(required = true, defaultValue = "0")int pageNum, @RequestParam(required = true, defaultValue = "5")int pageSize){
        List<Order> orderList = ordersService.findAll(pageNum, pageSize);
        //用PageInfo对结果进行包装
        PageInfo orderPage = new PageInfo(orderList);
        model.addAttribute("orderPage", orderPage);
        return "orders-list";
    }
    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam(name = "id", defaultValue = "1") int id){
        Order order = ordersService.findById(id);
        model.addAttribute("order", order);
        System.out.println(order);
        return "orders-show";
    }
}
