package dev.anuradha.productservice2025.services;

import dev.anuradha.productservice2025.models.Product;
import dev.anuradha.productservice2025.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getSingleProduct(long id){
        return null;
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> products =  productRepository.findAll();
        return products;
    }
}
