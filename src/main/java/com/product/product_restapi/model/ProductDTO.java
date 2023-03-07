package com.product.product_restapi.model;

import lombok.Data;

@Data
public class ProductDTO {
    private Long productId;
    private String productName;
    private String productImage;
    private String productDescription;
    private int productPrice;
    private int productTotal;
    private String productCreatedDate;
    private String productLastModified;
    private int productStatus;
}
