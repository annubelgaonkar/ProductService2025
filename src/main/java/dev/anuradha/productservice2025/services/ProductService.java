package dev.anuradha.productservice2025.services;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.exceptions.ProductNotFoundException;
import dev.anuradha.productservice2025.models.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id) throws ProductNotFoundException;

    Product createProduct(String title,
                          String description,
                          double price,
                          String imageUrl,
                          String category);


}
