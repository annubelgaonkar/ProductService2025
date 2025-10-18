package dev.anuradha.productservice2025.controllers;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProduct(){
       return null;
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return null;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return null;
    }
}
