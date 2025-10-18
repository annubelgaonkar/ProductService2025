package dev.anuradha.productservice2025.controllers;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.models.Product;
import dev.anuradha.productservice2025.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private RestTemplate restTemplate;

    public ProductService productService;

    public ProductController(ProductService productService, RestTemplate restTemplate){
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
       return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto);
    }
}
