package dev.anuradha.productservice2025.services;

import dev.anuradha.productservice2025.models.Category;
import dev.anuradha.productservice2025.models.Product;
import dev.anuradha.productservice2025.repositories.CategoryRepository;
import dev.anuradha.productservice2025.repositories.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SelfProductService")
@AllArgsConstructor
@Setter
@Getter
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Product getSingleProduct(long id){
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> products =  productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryFromDatabase = categoryRepository.findByTitle(category);

        if(categoryFromDatabase == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
            product.setCategory(newCategory);
            // categoryRepository.save(newCategory);
        }
        else {
            product.setCategory(categoryFromDatabase);
        }
        Product createdProduct = productRepository.save(product);
        return createdProduct;
    }
}
