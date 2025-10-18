package dev.anuradha.productservice2025.dtos;

import dev.anuradha.productservice2025.models.Category;
import dev.anuradha.productservice2025.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FakeStoreProductDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);

        Category category1 = new Category();
        category1.setTitle(category);

        product.setCategory(category1);
        product.setImageUrl(image);
        return product;

    }
}
