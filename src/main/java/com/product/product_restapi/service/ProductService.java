package com.product.product_restapi.service;

import com.product.product_restapi.model.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long productID);
    ProductDTO updateProduct(ProductDTO productDTO, long productId);
    void deleteProductById(long productId);
}
