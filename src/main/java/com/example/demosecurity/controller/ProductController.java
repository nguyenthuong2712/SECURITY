package com.example.demosecurity.controller;

import com.example.demosecurity.dto.ProductDTO;
import com.example.demosecurity.entity.Product;
import com.example.demosecurity.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("show")
    public ResponseEntity<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return productService.create(productDTO);
    }
}
