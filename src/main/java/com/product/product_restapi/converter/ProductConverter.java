package com.product.product_restapi.converter;

import com.product.product_restapi.model.Product;
import com.product.product_restapi.model.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {
    /**
     * Method to convert Product Entity to ProductDTO<br>
     *<u><i>Update:20/03/2023</i></u>
     * @param product
     * @return
     */
    public ProductDTO toDTO(Product product){

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductImage(product.getProductImage());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductTotal(product.getProductTotal());
        productDTO.setProductCreatedDate(product.getProductCreatedDate());
        productDTO.setProductLastModified(product.getProductLastModified());
        productDTO.setProductStatus(product.getProductStatus());

        return productDTO;
    }

    /**
     * Method to convert ProductDTO to Product Entity<br>
     *<u><i>Update:20/03/2023</i></u>
     * @param productDTO
     * @return
     */
    public Product toEntity(ProductDTO productDTO){
        Product product = new Product();

        product.setProductName(productDTO.getProductName());
        product.setProductImage(productDTO.getProductImage());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductTotal(productDTO.getProductTotal());
        product.setProductCreatedDate(productDTO.getProductCreatedDate());
        product.setProductLastModified(productDTO.getProductLastModified());
        product.setProductStatus(productDTO.getProductStatus());

        return product;
    }
}
