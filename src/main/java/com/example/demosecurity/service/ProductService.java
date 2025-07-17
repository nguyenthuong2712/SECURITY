package com.example.demosecurity.service;

import com.example.demosecurity.dto.ProductDTO;
import com.example.demosecurity.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity getAll();

    ResponseEntity<ProductDTO> create(ProductDTO productDTO);

    ResponseEntity<ProductDTO> save(ProductDTO productDTO,Integer id);
}
