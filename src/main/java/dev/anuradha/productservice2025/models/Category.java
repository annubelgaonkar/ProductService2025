package dev.anuradha.productservice2025.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel{
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;

}
