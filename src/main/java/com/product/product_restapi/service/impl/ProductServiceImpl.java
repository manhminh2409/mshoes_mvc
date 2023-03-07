package com.product.product_restapi.service.impl;

import com.product.product_restapi.exception.ResourceNotFoundException;
import com.product.product_restapi.model.Product;
import com.product.product_restapi.model.ProductDTO;
import com.product.product_restapi.repository.ProductRepository;
import com.product.product_restapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Method to create new Product<br>
     * <u><i>Update: 20/02/2023</i></u>
     * @param productDTO
     * @return productDTO
     *
     */
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        //Get current date and set productCreatedDate, productLastModified
        productDTO.setProductCreatedDate(this.getCurrentDate());
        productDTO.setProductLastModified(this.getCurrentDate());
        //Convert DTO to entity
        Product product = toEntity(productDTO);

        //Save new Product
        Product newProduct = productRepository.save(product);

        //Convert entity to DTO
        ProductDTO productResponse = toDTO(newProduct);

        return productResponse;
    }


    /**
     * Method to get all products from database<br>
     * <u><i>Update:20/02/2023</i></u>
     * @return
     *
     */
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products= productRepository.findAll();
        return products.stream().map(product -> toDTO(product)).collect(Collectors.toList());
    }

    /**
     * Method to get a product by ID from database<br>
     * <u><i>Update:20/02/2023</i></u>
     * @return
     *
     */
    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","id", productId));
        return toDTO(product);
    }

    /**
     * Method to update product and save into database<br>
     * <u><i>Update:20/03/2023</i></u>
     * @param productDTO
     * @param productId
     * @return
     */
    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, long productId) {
        //get product by id from the database = get product information old
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","id", productId));

        //set new information
        product.setProductName(productDTO.getProductName());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductImage(productDTO.getProductImage());
        product.setProductStatus(productDTO.getProductStatus());
        product.setProductLastModified(this.getCurrentDate());
        product.setProductTotal(productDTO.getProductTotal());


        Product updateProduct = productRepository.save(product);
        return toDTO(updateProduct);
    }

    /**
     * Method to DELETE product by ID<br>
     * <u><i>Update:20/03/2023</i></u>
     * @param productId
     */
    @Override
    public void deleteProductById(long productId) {
        //get product by id from the database
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","id", productId));

        productRepository.delete(product);
    }

    //DTO = Data Transfer Object

    /**
     * Method to convert Product Entity to ProductDTO<br>
     *<u><i>Update:20/03/2023</i></u>
     * @param product
     * @return
     */
    private  ProductDTO toDTO(Product product){

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
    private Product toEntity(ProductDTO productDTO){
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

    /**
     * Method to get current date and convert to string <br>
     * <u><i>Update:20/02/2023</i></u>
     * @return
     */
    private String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
