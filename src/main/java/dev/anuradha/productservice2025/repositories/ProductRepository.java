package dev.anuradha.productservice2025.repositories;

import dev.anuradha.productservice2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    Product save(Product p);

    Product findById(long id);

}
