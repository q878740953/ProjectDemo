package com.ssm.controller;

import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView finAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.finAll();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll";
    }
}
