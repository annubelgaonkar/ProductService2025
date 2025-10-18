package dev.anuradha.productservice2025.dtos;

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
}
