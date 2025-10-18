package dev.anuradha.productservice2025.services;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.dtos.FakeStoreProductDto;
import dev.anuradha.productservice2025.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/1" + id,
                FakeStoreProductDto.class);

        return fakeStoreProductDto.toProduct();

    }

    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestDto) {
        return null;
    }
}
