package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    // jsr250
//    @RolesAllowed("ADMIN")
    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasRole(ADMIN)")
    public String finAll(Model model, @RequestParam(required = true, defaultValue = "1") int pageNum, @RequestParam(required = true, defaultValue = "5") int pageSize) throws Exception {
        List<Product> products = productService.finAll(pageNum, pageSize);
        PageInfo productList = new PageInfo(products);
        model.addAttribute("productList", productList);
        return "product-list";
    }
    @RequestMapping("/save")
    // 未生效，没有解决
//    @PreAuthorize("authentication.principal.username == 'administrator'")
    public String save(Product product) throws Exception {
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll";
    }
}
