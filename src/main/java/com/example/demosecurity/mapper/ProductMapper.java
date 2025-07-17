package com.example.demosecurity.mapper;

import com.example.demosecurity.dto.ProductDTO;
import com.example.demosecurity.entity.Product;

public class ProductMapper {

    public static Product productMapper(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public static ProductDTO productDTOMapper(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
