package com.product.product_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "PRODUCT", uniqueConstraints = {@UniqueConstraint(columnNames = {"productName"})}

)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column( nullable = false)
    @NotBlank(message = "Product's name cannot be null.")
    private String productName;
    @Column()
    private String productImage;
    @Column()
    private String productDescription;
    @Column(nullable = false)
    private int productPrice;
    @Column(nullable = false)
    private int productTotal;
    @Column(nullable = false)
    private String productCreatedDate;
    @Column(nullable = false)
    private String productLastModified;
    @Column(columnDefinition = "int default '1'")
    private int productStatus;
}
