package dev.anuradha.productservice2025.services;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.dtos.FakeStoreProductDto;
import dev.anuradha.productservice2025.exceptions.ProductNotFoundException;
import dev.anuradha.productservice2025.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDto){
            Product p = fakeStoreProductDto1.toProduct();
            products.add(p);
        }
        return products;
    }

    @Override
    public Product getSingleProduct(long id) {

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/1" + id,
                FakeStoreProductDto.class);

        if(fakeStoreProductDtoResponseEntity.getStatusCode() != HttpStatus.valueOf(200)){
          //handle
        }

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if (fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id " + id + " is not present with the service. It's an invalid id");
        }

        return fakeStoreProductDto.toProduct();

    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto fakeStoreProductDto1 =
                restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);

        return fakeStoreProductDto1.toProduct();

    }

}
