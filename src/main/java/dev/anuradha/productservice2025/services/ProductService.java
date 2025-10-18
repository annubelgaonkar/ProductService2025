package dev.anuradha.productservice2025.services;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.models.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long id);
    Product createProduct(CreateProductRequestDto createProductRequestDto);


}
