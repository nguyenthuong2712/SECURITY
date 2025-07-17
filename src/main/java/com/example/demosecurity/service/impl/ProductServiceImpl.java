package com.example.demosecurity.service.impl;

import com.example.demosecurity.dto.ProductDTO;
import com.example.demosecurity.entity.Product;
import com.example.demosecurity.mapper.ProductMapper;
import com.example.demosecurity.repository.ProductRepository;
import com.example.demosecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity getAll() {
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO productDTO) {
        Product product = ProductMapper.productMapper(productDTO);
        Product productCreate = productRepository.save(product);
        return new ResponseEntity<>(ProductMapper.productDTOMapper(productCreate),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDTO> save(ProductDTO productDTO,Integer id) {
        return null;
    }
}
