package com.nike.controller;

import java.util.List;

import com.nike.mapper.ProductMapper;
import com.nike.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        List<Product> products=productMapper.getAllProducts();
        return products;
    }

}