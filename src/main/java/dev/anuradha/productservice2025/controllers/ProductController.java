package dev.anuradha.productservice2025.controllers;

import dev.anuradha.productservice2025.dtos.CreateProductRequestDto;
import dev.anuradha.productservice2025.models.Product;
import dev.anuradha.productservice2025.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class ProductController {

    //private RestTemplate restTemplate;

    public final ProductService productService;


    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/products")
    public List<Product> getAllProduct(){
       return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) {
        Product p = productService.getSingleProduct(id);
        ResponseEntity<Product> responseEntity;

        if(p == null){
            responseEntity = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }
        else{
            responseEntity = new ResponseEntity<>(p, HttpStatus.OK);
        }
        return responseEntity;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(),
                                            createProductRequestDto.getDescription(),
                                            createProductRequestDto.getPrice(),
                                            createProductRequestDto.getImage(),
                                            createProductRequestDto.getCategory());
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(productNotFoundException.getMessage());
//        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    }
}
