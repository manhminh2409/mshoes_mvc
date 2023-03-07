package com.product.product_restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.product_restapi.converter.ProductConverter;
import com.product.product_restapi.model.Product;
import com.product.product_restapi.model.ProductDTO;
import com.product.product_restapi.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private final ProductConverter productConverter;

	public ProductController(ProductService productService, ProductConverter productConverter) {
		this.productService = productService;
		this.productConverter = productConverter;
	}

	@PostMapping("/add")
	public String createProduct(ModelMap modelMap, @Valid @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		ProductDTO productDTO = productConverter.toDTO(product);
		if (bindingResult.hasErrors()) {
			return "addproduct";
		}
		try {
			productService.createProduct(productDTO);
		} catch (Exception e) {

		}
		return "redirect:/products";

	}

	@GetMapping("/form_add")
	public String createProduct(ModelMap modelMap) {
		modelMap.addAttribute("product", new ProductDTO());
		return "addproduct";
	}

	// get All products
//    @GetMapping
//    public List<ProductDTO> getAllProducts(){
//        return productService.getAllProducts();
//    }
	@GetMapping
	public String getAllProducts(ModelMap modelMap) {
		List<ProductDTO> products = productService.getAllProducts();
		modelMap.addAttribute("products", products);
		return "products";
	}

	// get Product by ID
	@GetMapping("/{id}")
	public String getProductById(ModelMap modelMap, @PathVariable(name = "id") Long productId) {
		ProductDTO productDTO = productService.getProductById(productId);
		modelMap.addAttribute("product", productDTO);
		return "detailproduct";
	}

	// Update Product by ID
	@PostMapping("/update/{id}")
	public String updateProduct(ModelMap modelMap, @ModelAttribute Product product,
			@PathVariable(name = "id") long productId, BindingResult bindingResult) {
		ProductDTO productDTO = productConverter.toDTO(product);
		if (bindingResult.hasErrors()) {
			return "detailproduct";
		}
		try {
			productService.updateProduct(productDTO, productId);
		} catch (Exception e) {

		}
		return "redirect:/products";
	}

	// Delete Product by ID
	@GetMapping("/delete/{id}")
	public String deleteProduct(ModelMap modelMap, @PathVariable(name = "id") long productId) {
		productService.deleteProductById(productId);
		return "redirect:/products";
	}
}
