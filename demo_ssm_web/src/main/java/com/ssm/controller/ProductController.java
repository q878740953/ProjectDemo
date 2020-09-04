package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String finAll(Model model, @RequestParam(required = true, defaultValue = "1") int pageNum, @RequestParam(required = true, defaultValue = "5") int pageSize) throws Exception {
        List<Product> products = productService.finAll(pageNum, pageSize);
        PageInfo productList = new PageInfo(products);
        model.addAttribute("productList", productList);
        return "product-list";
    }
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll";
    }
}
